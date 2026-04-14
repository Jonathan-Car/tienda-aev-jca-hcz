package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import java.util.List;

public interface ICategoriaRepository {

    List<Categoria> findAll();
    Categoria findById(Long id);
    void save(Categoria categoria);
}
