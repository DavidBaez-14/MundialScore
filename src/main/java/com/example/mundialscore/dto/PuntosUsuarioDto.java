package com.example.mundialscore.dto;

public class PuntosUsuarioDto {
    private Long partidoId;
    private String equipoLocal;
    private String equipoVisitante;
    private Integer golesLocalPredicho;
    private Integer golesVisitantePredicho;
    private Integer golesLocalReal;
    private Integer golesVisitanteReal;
    private Integer puntosObtenidos;
    private boolean partidoFinalizado;

    // Constructores
    public PuntosUsuarioDto() {
    }

    // Getters y Setters
    public Long getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Long partidoId) {
        this.partidoId = partidoId;
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

    public Integer getGolesLocalPredicho() {
        return golesLocalPredicho;
    }

    public void setGolesLocalPredicho(Integer golesLocalPredicho) {
        this.golesLocalPredicho = golesLocalPredicho;
    }

    public Integer getGolesVisitantePredicho() {
        return golesVisitantePredicho;
    }

    public void setGolesVisitantePredicho(Integer golesVisitantePredicho) {
        this.golesVisitantePredicho = golesVisitantePredicho;
    }

    public Integer getGolesLocalReal() {
        return golesLocalReal;
    }

    public void setGolesLocalReal(Integer golesLocalReal) {
        this.golesLocalReal = golesLocalReal;
    }

    public Integer getGolesVisitanteReal() {
        return golesVisitanteReal;
    }

    public void setGolesVisitanteReal(Integer golesVisitanteReal) {
        this.golesVisitanteReal = golesVisitanteReal;
    }

    public Integer getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(Integer puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public boolean isPartidoFinalizado() {
        return partidoFinalizado;
    }

    public void setPartidoFinalizado(boolean partidoFinalizado) {
        this.partidoFinalizado = partidoFinalizado;
    }
}
