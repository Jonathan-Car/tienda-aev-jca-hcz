package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarritoResumenDto {
    private Long cantidadProductosDistintos;
    private Integer totalUnidades;
    private Double importeTotal;
}