package com.example.mundialscore.controller;

import com.example.mundialscore.dto.PrediccionDto;
import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Prediccion;
import com.example.mundialscore.entity.Usuario;
import com.example.mundialscore.repository.PartidoRepository;
import com.example.mundialscore.repository.PrediccionRepository;
import com.example.mundialscore.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/predictions")
@Tag(name = "Predicciones", description = "Operaciones de apuestas de usuarios")
public class PrediccionController {

    private final PrediccionRepository prediccionRepository;
    private final PartidoRepository partidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PrediccionController(PrediccionRepository prediccionRepository, PartidoRepository partidoRepository,
            UsuarioRepository usuarioRepository) {
        this.prediccionRepository = prediccionRepository;
        this.partidoRepository = partidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @Operation(summary = "Enviar una predicción")
    public ResponseEntity<String> predecir(@RequestBody PrediccionDto dto, Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
        Partido partido = partidoRepository.findById(dto.getPartidoId()).orElse(null);

        if (partido == null)
            return ResponseEntity.badRequest().body("Partido no encontrado");
        if (partido.isFinalizado())
            return ResponseEntity.badRequest().body("El partido ya finalizó");

        Optional<Prediccion> existente = prediccionRepository.findByUsuarioAndPartido(usuario, partido);
        Prediccion prediccion;
        if (existente.isPresent()) {
            prediccion = existente.get();
        } else {
            prediccion = new Prediccion();
            prediccion.setUsuario(usuario);
            prediccion.setPartido(partido);
        }

        prediccion.setGolesLocalPredichos(dto.getGolesLocal());
        prediccion.setGolesVisitantePredichos(dto.getGolesVisitante());
        prediccionRepository.save(prediccion);

        return ResponseEntity.ok("Predicción guardada");
    }

    @GetMapping("/my-predictions")
    @Operation(summary = "Obtener predicciones del usuario actual")
    public List<Prediccion> misPredicciones(Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
        return prediccionRepository.findByUsuario(usuario);
    }
}
