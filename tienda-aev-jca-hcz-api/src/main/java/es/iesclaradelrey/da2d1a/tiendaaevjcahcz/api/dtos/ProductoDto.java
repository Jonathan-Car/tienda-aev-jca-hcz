package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProductoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private MarcaDto marca; // Incluye marca
    private List<CategoriaDto> categorias; // Incluye categorías
}