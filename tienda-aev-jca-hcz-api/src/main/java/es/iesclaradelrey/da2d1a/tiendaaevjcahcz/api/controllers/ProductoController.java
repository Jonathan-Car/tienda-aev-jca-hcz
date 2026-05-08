package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.ProductoDto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.mappers.ProductoMapper;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {

    private final IProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoController(IProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @GetMapping
    public List<ProductoDto> getAll() {
        // Ordenación alfabética por nombre con Sort (3.6)
        return productoMapper.toDto(productoRepository.findAll(Sort.by("nombre")));
    }
}