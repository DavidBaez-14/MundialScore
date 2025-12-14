package com.example.mundialscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "predicciones", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "usuario_id", "partido_id" })
})
public class Prediccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    private int golesLocalPredichos;
    private int golesVisitantePredichos;

    private int puntosObtenidos;

    public Prediccion() {
        this.puntosObtenidos = 0;
    }

    public Prediccion(Usuario usuario, Partido partido, int golesLocalPredichos, int golesVisitantePredichos) {
        this.usuario = usuario;
        this.partido = partido;
        this.golesLocalPredichos = golesLocalPredichos;
        this.golesVisitantePredichos = golesVisitantePredichos;
        this.puntosObtenidos = 0;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getGolesLocalPredichos() {
        return golesLocalPredichos;
    }

    public void setGolesLocalPredichos(int golesLocalPredichos) {
        this.golesLocalPredichos = golesLocalPredichos;
    }

    public int getGolesVisitantePredichos() {
        return golesVisitantePredichos;
    }

    public void setGolesVisitantePredichos(int golesVisitantePredichos) {
        this.golesVisitantePredichos = golesVisitantePredichos;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
}
