package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Segunda parte del 11-3.1
 * Fecha-hora evento
 * nombre usu evento
 * tipo evento (enum)
 */
@Entity
public class EventoSeguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;
    private String usuario;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento; // enum

    public EventoSeguridad() {
    }

    public EventoSeguridad(String usuario, TipoEvento tipoEvento) {
        this.usuario = usuario;
        this.tipoEvento = tipoEvento;
        this.fechaHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
