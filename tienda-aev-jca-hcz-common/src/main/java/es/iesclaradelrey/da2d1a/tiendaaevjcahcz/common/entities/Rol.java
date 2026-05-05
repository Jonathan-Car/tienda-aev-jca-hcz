package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Column(length = 6)
    private String id;

    @Column(nullable = false, length = 100)
    private String descripcion;

    public Rol() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}