package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    void save(Producto producto, MultipartFile archivoImagen);
    void deleteById(Long id);
}
