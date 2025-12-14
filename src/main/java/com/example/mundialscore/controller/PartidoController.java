package com.example.mundialscore.controller;

import com.example.mundialscore.dto.ResultadoPartidoDto;
import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Prediccion;
import com.example.mundialscore.entity.Usuario;
import com.example.mundialscore.repository.PartidoRepository;
import com.example.mundialscore.repository.PrediccionRepository;
import com.example.mundialscore.repository.UsuarioRepository;
import com.example.mundialscore.service.ServicioPuntuacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Partidos", description = "Operaciones relacionadas con los partidos")
public class PartidoController {

    private final PartidoRepository partidoRepository;
    private final PrediccionRepository prediccionRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicioPuntuacion servicioPuntuacion;

    public PartidoController(PartidoRepository partidoRepository, PrediccionRepository prediccionRepository,
            UsuarioRepository usuarioRepository, ServicioPuntuacion servicioPuntuacion) {
        this.partidoRepository = partidoRepository;
        this.prediccionRepository = prediccionRepository;
        this.usuarioRepository = usuarioRepository;
        this.servicioPuntuacion = servicioPuntuacion;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los partidos")
    public List<Partido> obtenerPartidos() {
        return partidoRepository.findAll();
    }

    @PutMapping("/{id}/result")
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
        List<Prediccion> predicciones = prediccionRepository.findByPartido(partido);
        for (Prediccion p : predicciones) {
            int puntos = servicioPuntuacion.calcularPuntos(partido, p);
            p.setPuntosObtenidos(puntos);
            prediccionRepository.save(p);

            // Actualizar usuario
            Usuario usuario = p.getUsuario();
            recalcularPuntosUsuario(usuario);
        }

        return ResponseEntity.ok("Partido actualizado y puntos recalculados");
    }

    private void recalcularPuntosUsuario(Usuario usuario) {
        List<Prediccion> todasPredicciones = prediccionRepository.findByUsuario(usuario);
        int total = todasPredicciones.stream().mapToInt(Prediccion::getPuntosObtenidos).sum();
        usuario.setPuntosTotales(total);
        usuarioRepository.save(usuario);
    }
}
