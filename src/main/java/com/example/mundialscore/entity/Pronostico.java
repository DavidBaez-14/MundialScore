package com.example.mundialscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pronosticos", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "usuario_id", "partido_id" })
})
public class Pronostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    private int golesLocalPronosticados;
    private int golesVisitantePronosticados;

    private int puntosObtenidos;

    public Pronostico() {
        this.puntosObtenidos = 0;
    }

    public Pronostico(Usuario usuario, Partido partido, int golesLocalPronosticados, int golesVisitantePronosticados) {
        this.usuario = usuario;
        this.partido = partido;
        this.golesLocalPronosticados = golesLocalPronosticados;
        this.golesVisitantePronosticados = golesVisitantePronosticados;
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

    public int getGolesLocalPronosticados() {
        return golesLocalPronosticados;
    }

    public void setGolesLocalPronosticados(int golesLocalPronosticados) {
        this.golesLocalPronosticados = golesLocalPronosticados;
    }

    public int golesVisitantePronosticados() {
        return golesVisitantePronosticados;
    }

    public void setGolesVisitantePronosticados(int golesVisitantePronosticados) {
        this.golesVisitantePronosticados = golesVisitantePronosticados;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
}
