package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.*;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.exceptions.*;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.repositories.CarritoItemRepository;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.CarritoItem;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarritoService {

    private final CarritoItemRepository carritoRepository;
    private final IProductoRepository productoRepository;

    @Transactional
    public CarritoListadoDto agregarProducto(Usuario usuario, Long productoId, Integer unidades) {

        if (unidades <= 0) throw new UnidadesInvalidasException("Las unidades deben ser mayores que 0");

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNoEncontradoException(productoId));

        if (producto.getStock() < unidades)
            throw new StockInsuficienteException("No hay stock suficiente del producto: " + producto.getNombre());

        CarritoItem item = carritoRepository.findByUsuarioAndProducto(usuario, producto)
                .orElse(new CarritoItem(usuario, producto, 0));

        item.setUnidades(item.getUnidades() + unidades);
        carritoRepository.save(item);

        return obtenerCarrito(usuario);
    }

    public CarritoListadoDto obtenerCarrito(Usuario usuario) {
        List<CarritoItem> items = carritoRepository.findByUsuario(usuario);

        List<CarritoItemDto> itemsDto = items.stream().map(item -> CarritoItemDto.builder()
                .productoId(item.getProducto().getId())
                .nombreProducto(item.getProducto().getNombre())
                .precioUnitario(item.getProducto().getPrecio())
                .unidades(item.getUnidades())
                .precioTotal(item.getProducto().getPrecio() * item.getUnidades())
                .build()).collect(Collectors.toList());

        CarritoResumenDto resumen = CarritoResumenDto.builder()
                .cantidadProductosDistintos(carritoRepository.countDistinctProductosByUsuario(usuario))
                .totalUnidades(carritoRepository.sumUnidadesByUsuario(usuario))
                .importeTotal(carritoRepository.sumImporteTotalByUsuario(usuario))
                .build();

        return CarritoListadoDto.builder()
                .items(itemsDto)
                .resumen(resumen)
                .build();
    }

    @Transactional
    public CarritoListadoDto eliminarProducto(Usuario usuario, Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNoEncontradoException(productoId));

        CarritoItem item = carritoRepository.findByUsuarioAndProducto(usuario, producto)
                .orElseThrow(() -> new StockInsuficienteException("El producto no está en el carrito"));

        carritoRepository.delete(item);
        return obtenerCarrito(usuario);
    }

    @Transactional
    public CarritoListadoDto vaciarCarrito(Usuario usuario) {
        carritoRepository.deleteByUsuario(usuario);
        return obtenerCarrito(usuario);
    }
}