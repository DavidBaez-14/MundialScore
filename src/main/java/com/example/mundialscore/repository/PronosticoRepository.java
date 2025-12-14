package com.example.mundialscore.repository;

import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Pronostico;
import com.example.mundialscore.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {
    List<Pronostico> findByUsuario(Usuario usuario);

    Optional<Pronostico> findByUsuarioAndPartido(Usuario usuario, Partido partido);

    List<Pronostico> findByPartido(Partido partido);
}
