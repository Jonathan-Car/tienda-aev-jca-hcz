package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.mappers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.CategoriaDto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDto toDto(Categoria categoria);
    List<CategoriaDto> toDto(List<Categoria> categorias);
}
