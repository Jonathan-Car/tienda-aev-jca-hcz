package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.ICategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
    @Override
    public List<Producto> obtenerProductosDeCategoria(Long id) {
        Categoria cat = categoriaRepository.findById(id).orElseThrow();

        return cat.getProductos().stream()
                // Filtramos posibles nulos para evitar errores en la vista
                .filter(p -> p.getNombre() != null)
                // Ordenamos alfabéticamente (case insensitive)
                .sorted(Comparator.comparing(p -> p.getNombre().toLowerCase()))
                .toList();
    }
}
