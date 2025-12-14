package com.example.mundialscore.repository;

import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Prediccion;
import com.example.mundialscore.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrediccionRepository extends JpaRepository<Prediccion, Long> {
    List<Prediccion> findByUsuario(Usuario usuario);

    Optional<Prediccion> findByUsuarioAndPartido(Usuario usuario, Partido partido);

    List<Prediccion> findByPartido(Partido partido);
}
