package com.example.mundialscore.controller;

import com.example.mundialscore.dto.ResultadoPartidoDto;
import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Pronostico;
import com.example.mundialscore.entity.Usuario;
import com.example.mundialscore.repository.PartidoRepository;
import com.example.mundialscore.repository.PronosticoRepository;
import com.example.mundialscore.repository.UsuarioRepository;
import com.example.mundialscore.service.ServicioPuntuacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@Tag(name = "Partidos", description = "Operaciones relacionadas con los partidos")
public class PartidoController {

    private final PartidoRepository partidoRepository;
    private final PronosticoRepository pronosticoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicioPuntuacion servicioPuntuacion;

    public PartidoController(PartidoRepository partidoRepository, PronosticoRepository pronosticoRepository,
            UsuarioRepository usuarioRepository, ServicioPuntuacion servicioPuntuacion) {
        this.partidoRepository = partidoRepository;
        this.pronosticoRepository = pronosticoRepository;
        this.usuarioRepository = usuarioRepository;
        this.servicioPuntuacion = servicioPuntuacion;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los partidos")
    public List<Partido> obtenerPartidos() {
        return partidoRepository.findAll();
    }

    @GetMapping("/disponibles")
    @Operation(summary = "Obtener partidos disponibles para apostar (no finalizados)")
    public List<Partido> obtenerPartidosDisponibles() {
        return partidoRepository.findByFinalizadoFalse();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un partido por ID")
    public ResponseEntity<Partido> obtenerPartido(@PathVariable Long id) {
        return partidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/grupo/{grupo}")
    @Operation(summary = "Obtener partidos por grupo")
    public List<Partido> obtenerPartidosPorGrupo(@PathVariable String grupo) {
        return partidoRepository.findByGrupo(grupo);
    }

    @GetMapping("/grupo/{grupo}/disponibles")
    @Operation(summary = "Obtener partidos disponibles de un grupo")
    public List<Partido> obtenerPartidosDisponiblesPorGrupo(@PathVariable String grupo) {
        return partidoRepository.findByGrupoAndFinalizadoFalse(grupo);
    }

    @GetMapping("/grupo/{grupo}/fecha/{fecha}")
    @Operation(summary = "Obtener partidos por grupo y fecha")
    public List<Partido> obtenerPartidosPorGrupoYFecha(@PathVariable String grupo, @PathVariable Integer fecha) {
        return partidoRepository.findByGrupoAndFecha(grupo, fecha);
    }

    @GetMapping("/fecha/{fecha}")
    @Operation(summary = "Obtener todos los partidos de una fecha")
    public List<Partido> obtenerPartidosPorFecha(@PathVariable Integer fecha) {
        return partidoRepository.findByFecha(fecha);
    }

    @GetMapping("/fase/{fase}")
    @Operation(summary = "Obtener partidos por fase (GRUPOS, OCTAVOS, etc.)")
    public List<Partido> obtenerPartidosPorFase(@PathVariable String fase) {
        return partidoRepository.findByFase(fase);
    }

    @PutMapping("/{id}/resultado")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Actualizar resultado del partido (Solo Admin)", description = "Establece el marcador y recalcula los puntos de los usuarios")
    public ResponseEntity<String> actualizarResultado(@PathVariable Long id,
            @RequestBody ResultadoPartidoDto resultado) {
        Partido partido = partidoRepository.findById(id).orElse(null);
        if (partido == null)
            return ResponseEntity.notFound().build();

        partido.setGolesLocal(resultado.getGolesLocal());
        partido.setGolesVisitante(resultado.getGolesVisitante());
        partido.setFinalizado(true);
        partidoRepository.save(partido);

        // Recalcular puntos
        List<Pronostico> pronosticos = pronosticoRepository.findByPartido(partido);
        for (Pronostico p : pronosticos) {
            int puntos = servicioPuntuacion.calcularPuntos(partido, p);
            p.setPuntosObtenidos(puntos);
            pronosticoRepository.save(p);

            // Actualizar usuario
            Usuario usuario = p.getUsuario();
            recalcularPuntosUsuario(usuario);
        }

        return ResponseEntity.ok("Partido actualizado y puntos recalculados");
    }

    private void recalcularPuntosUsuario(Usuario usuario) {
        List<Pronostico> todosPronosticos = pronosticoRepository.findByUsuario(usuario);
        int total = todosPronosticos.stream().mapToInt(Pronostico::getPuntosObtenidos).sum();
        usuario.setPuntosTotales(total);
        usuarioRepository.save(usuario);
    }
}
