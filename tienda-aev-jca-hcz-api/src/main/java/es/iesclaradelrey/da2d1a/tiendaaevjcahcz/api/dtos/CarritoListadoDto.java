package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CarritoListadoDto {
    private List<CarritoItemDto> items;
    private CarritoResumenDto resumen;
}