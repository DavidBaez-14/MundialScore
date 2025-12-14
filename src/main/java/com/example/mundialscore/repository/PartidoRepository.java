package com.example.mundialscore.repository;

import com.example.mundialscore.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByFinalizadoFalse();
    
    // Filtros por grupo
    List<Partido> findByGrupo(String grupo);
    List<Partido> findByGrupoAndFinalizadoFalse(String grupo);
    
    // Filtros por fecha
    List<Partido> findByFecha(Integer fecha);
    
    // Filtros combinados
    List<Partido> findByGrupoAndFecha(String grupo, Integer fecha);
    List<Partido> findByGrupoAndFechaAndFinalizadoFalse(String grupo, Integer fecha);
    
    // Filtros por fase
    List<Partido> findByFase(String fase);
    List<Partido> findByFaseAndFinalizadoFalse(String fase);
}
