package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;

import java.util.List;

public interface IMarcaService {
    List<Marca> findAll();
    Marca findById(Long id);
    void save(Marca marca);
    void deleteById(Long id);
    List<Producto> obtenerProductosDeMarca(Long marcaId);
}
