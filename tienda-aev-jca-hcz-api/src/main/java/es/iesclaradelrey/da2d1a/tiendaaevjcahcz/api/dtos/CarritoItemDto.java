package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarritoItemDto {
    private Long productoId;
    private String nombreProducto;
    private Double precioUnitario;
    private Integer unidades;
    private Double precioTotal;
}