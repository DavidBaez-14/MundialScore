package com.example.mundialscore.controller;

import com.example.mundialscore.dto.PronosticoDto;
import com.example.mundialscore.dto.PuntosUsuarioDto;
import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Pronostico;
import com.example.mundialscore.entity.Usuario;
import com.example.mundialscore.repository.PartidoRepository;
import com.example.mundialscore.repository.PronosticoRepository;
import com.example.mundialscore.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pronosticos")
@Tag(name = "Pronosticos", description = "Operaciones de apuestas de usuarios")
public class PronosticoController {

    private final PronosticoRepository pronosticoRepository;
    private final PartidoRepository partidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PronosticoController(PronosticoRepository pronosticoRepository, PartidoRepository partidoRepository,
            UsuarioRepository usuarioRepository) {
        this.pronosticoRepository = pronosticoRepository;
        this.partidoRepository = partidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @Operation(summary = "Enviar un pronóstico")
    public ResponseEntity<String> pronosticar(@RequestBody PronosticoDto dto, Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
        Partido partido = partidoRepository.findById(dto.getPartidoId()).orElse(null);

        if (partido == null)
            return ResponseEntity.badRequest().body("Partido no encontrado");
        if (partido.isFinalizado())
            return ResponseEntity.badRequest().body("El partido ya finalizó");

        Optional<Pronostico> existente = pronosticoRepository.findByUsuarioAndPartido(usuario, partido);
        Pronostico pronostico;
        if (existente.isPresent()) {
            pronostico = existente.get();
        } else {
            pronostico = new Pronostico();
            pronostico.setUsuario(usuario);
            pronostico.setPartido(partido);
        }

        pronostico.setGolesLocalPronosticados(dto.getGolesLocal());
        pronostico.setGolesVisitantePronosticados(dto.getGolesVisitante());
        pronosticoRepository.save(pronostico);

        return ResponseEntity.ok("Pronóstico guardado");
    }

    @GetMapping("/pronosticos-usuario")
    @Operation(summary = "Obtener pronósticos del usuario actual")
    public List<Pronostico> misPronosticos(Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
        return pronosticoRepository.findByUsuario(usuario);
    }

    @GetMapping("/puntos")
    @Operation(summary = "Obtener puntos obtenidos por partido del usuario actual")
    public ResponseEntity<List<PuntosUsuarioDto>> misPuntos(Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
        List<Pronostico> pronosticos = pronosticoRepository.findByUsuario(usuario);
        
        List<PuntosUsuarioDto> puntosDto = pronosticos.stream().map(p -> {
            PuntosUsuarioDto dto = new PuntosUsuarioDto();
            dto.setPartidoId(p.getPartido().getId());
            dto.setEquipoLocal(p.getPartido().getEquipoLocal());
            dto.setEquipoVisitante(p.getPartido().getEquipoVisitante());
            dto.setGolesLocalPredicho(p.getGolesLocalPronosticados());
            dto.setGolesVisitantePredicho(p.getGolesVisitantePronosticados());
            dto.setGolesLocalReal(p.getPartido().getGolesLocal());
            dto.setGolesVisitanteReal(p.getPartido().getGolesVisitante());
            dto.setPuntosObtenidos(p.getPuntosObtenidos());
            dto.setPartidoFinalizado(p.getPartido().isFinalizado());
            return dto;
        }).collect(Collectors.toList());
        
        return ResponseEntity.ok(puntosDto);
    }

    @GetMapping
    @Operation(summary = "Obtener todos los pronósticos (Admin)")
    public List<Pronostico> todosLosPronosticos() {
        return pronosticoRepository.findAll();
    }
}
