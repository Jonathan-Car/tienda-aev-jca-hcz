package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IMarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl implements IMarcaService {
    @Autowired
    private IMarcaRepository marcaRepository;

    @Override
    public List<Marca> findAll() { return marcaRepository.findAll(); }

    @Override
    public Marca findById(Long id) { return marcaRepository.findById(id).orElse(null); }

    @Override
    public void save(Marca marca) { marcaRepository.save(marca); }

    @Override
    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }
    @Override
    public List<Producto> obtenerProductosDeMarca(Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId).orElse(null);
        if (marca == null) return null;

        return marca.getProductos().stream()
                .sorted(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}
