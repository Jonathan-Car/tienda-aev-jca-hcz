package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

/*
* Responsable de catálogo y visualización de productos
* Fichero 05
* */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    // Inyección dependencias (repositorio)
    private final IProductoRepository productoRepository;

    public ProductoController(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Lista productos disponibles
    @GetMapping
    public String listado(Model model) {
        List<Producto> productos = productoRepository.findAll();
        // Ordenación por nombre (alfabéticamente)
        productos.sort(Comparator.comparing(Producto::getNombre));
        model.addAttribute("productos", productos);
        return "productos/listado";
    }

    // Detalle
    @GetMapping("/{id}/{nombre}")
    public String detalle(@PathVariable Long id, @PathVariable String nombre, Model model) {
        // Búsqueda por ID, ignora nombre
        Producto producto = productoRepository.findById(id).orElseThrow();
        model.addAttribute("producto", producto);
        return "productos/detalle";
    }
}
