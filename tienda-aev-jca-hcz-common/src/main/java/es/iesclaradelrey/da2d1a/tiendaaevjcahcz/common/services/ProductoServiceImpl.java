package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService {
    private final IProductoRepository productoRepository;

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
    public void save(Producto producto, MultipartFile archivoImagen) {
        if (archivoImagen != null && !archivoImagen.isEmpty()) {
            String nombreArchivo = archivoImagen.getOriginalFilename();
            producto.setImagen(nombreArchivo);
        }
        productoRepository.save(producto);
    }
    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
