package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IMarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
