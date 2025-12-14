package com.example.mundialscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipoLocal;
    private String equipoVisitante;

    private Integer golesLocal;
    private Integer golesVisitante;

    private boolean finalizado;

    private String grupo;  // A, B, C, D, E, F, G, H, I, J, K, L
    private Integer fecha;  // 1, 2, 3
    private String fase;    // GRUPOS, DIECISEISAVOS, OCTAVOS, CUARTOS, SEMIFINAL, FINAL

    public Partido() {
        this.finalizado = false;
    }

    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.finalizado = false;
        this.fase = "GRUPOS";
    }

    public Partido(String equipoLocal, String equipoVisitante, String grupo, Integer fecha, String fase) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.finalizado = false;
        this.grupo = grupo;
        this.fecha = fecha;
        this.fase = fase;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}
