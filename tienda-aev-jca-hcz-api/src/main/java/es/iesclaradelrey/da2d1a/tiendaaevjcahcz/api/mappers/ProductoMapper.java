package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.mappers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.ProductoDto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDto toDto(Producto producto);
    List<ProductoDto> toDto(List<Producto> productos);
}
