package com.example.mundialscore.controller;

import com.example.mundialscore.entity.Usuario;
import com.example.mundialscore.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@Tag(name = "Ranking", description = "Tabla de clasificación")
public class ControladorRanking {

    private final UsuarioRepository usuarioRepository;

    public ControladorRanking(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    @Operation(summary = "Obtener tabla de clasificación de usuarios")
    public List<Usuario> obtenerRanking() {
        return usuarioRepository.findAllByOrderByPuntosTotalesDesc();
    }
}
