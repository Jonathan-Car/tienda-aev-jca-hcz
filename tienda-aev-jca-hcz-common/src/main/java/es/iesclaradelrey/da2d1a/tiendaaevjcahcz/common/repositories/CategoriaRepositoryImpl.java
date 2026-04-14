package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoriaRepositoryImpl implements ICategoriaRepository {

    private Map<Long, Categoria> categorias = new HashMap<>();


    @Override
    public List<Categoria> findAll() {

        return new ArrayList<Categoria>(categorias.values());
    }

    @Override
    public Categoria findById(Long id) {

        return categorias.get(id);
    }

    @Override
    public void save(Categoria categoria) {

        categorias.put(categoria.getId(), categoria);
    }

}
