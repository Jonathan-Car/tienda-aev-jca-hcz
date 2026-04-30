package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    private final IProductoRepository productoRepository;
    private final String ubicacionP = "src/main/resources/static/imagenes/productos/";
    public ProductoServiceImpl(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll().stream()
                .filter(p -> p.getNombre() != null)
                .sorted(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }
    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }
    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
