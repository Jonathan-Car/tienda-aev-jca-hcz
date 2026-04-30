package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El código EAN es obligatorio")
    @Size(min = 13, max = 13, message = "El código EAN debe tener 13 dígitos")
    @Column(nullable = false, length = 13, unique = true)
    private String codigoProducto;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 4000)
    @Column(nullable = false, length = 4000)
    private String descripcion;

    @Column(length = 500)
    private String imagen;

    @NotNull(message = "El precio es obligatorio")
    @PositiveOrZero(message = "El precio debe ser positivo")
    @Column(nullable = false)
    private Double precio;

    @Min(0)
    @Max(99)
    @Column(nullable = false)
    private int descuento;

    // Un producto siempre tiene una marca (7-3.1)
    @NotNull(message = "La marca es obligatoria")
    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    // Producto puede pertenecer a varias categorías o ninguna (7-3.1)
    @ManyToMany
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Producto() {
    }

    public Producto(Long id, String codigoProducto, String nombre, String descripcion, String imagen, Double precio, int descuento, Marca marca, List<Categoria> categorias) {
        this.id = id;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.descuento = descuento;
        this.marca = marca;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}