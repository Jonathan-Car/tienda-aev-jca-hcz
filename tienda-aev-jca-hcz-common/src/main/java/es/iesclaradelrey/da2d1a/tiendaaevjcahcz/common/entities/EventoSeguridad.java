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
    private String username;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento; // enum

    public EventoSeguridad() {
    }

    public EventoSeguridad(Long id, LocalDateTime fechaHora, String username, TipoEvento tipoEvento) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.username = username;
        this.tipoEvento = tipoEvento;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
