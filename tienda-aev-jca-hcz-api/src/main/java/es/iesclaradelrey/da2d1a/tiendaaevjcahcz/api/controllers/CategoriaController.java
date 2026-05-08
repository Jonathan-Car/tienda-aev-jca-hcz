package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.CategoriaDto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.ProductoDto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.mappers.CategoriaMapper;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.mappers.ProductoMapper;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.ICategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final ICategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    private final IProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public CategoriaController(ICategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper, IProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @GetMapping
    public List<CategoriaDto> getAll() {
        // Ordenación alfabética por nombre usando Sort (3.5)
        return categoriaMapper.toDto(categoriaRepository.findAll(Sort.by("nombre")));
    }

    @GetMapping("/{categoriaId}/productos")
    public List<ProductoDto> getProductosByCategoria(@PathVariable Long categoriaId) {
        // Usar método derivado del repositorio
        // Pasar Sort.by("nombre") como parámetro (3.7)
        List<Producto> productos = productoRepository.findByCategorias_Id(categoriaId, Sort.by("nombre"));

        // Mapear a DTO
        return productoMapper.toDto(productos);
    }
}
