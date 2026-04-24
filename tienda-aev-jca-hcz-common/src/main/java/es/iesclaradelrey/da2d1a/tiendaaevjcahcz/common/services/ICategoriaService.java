package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import java.util.List;

public interface ICategoriaService {
    List<Categoria> findAll();
    Categoria findById(Long id);
    void save(Categoria categoria);
    void deleteById(Long id);
}
