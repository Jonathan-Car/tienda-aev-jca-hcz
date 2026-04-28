package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    private final IProductoRepository productoRepository;

    public ProductoServiceImpl(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public List<Producto> findAll(){
        return productoRepository.findAll();
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
