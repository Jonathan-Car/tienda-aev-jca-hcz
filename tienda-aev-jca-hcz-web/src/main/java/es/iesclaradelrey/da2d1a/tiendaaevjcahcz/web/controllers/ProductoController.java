package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IProductoService;
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

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    // Lista general de catálogo
    @GetMapping({"/", ""})
    public String listado(Model model) {
        // findAll() de ServiceImpl que ya tiene el Comparator A-Z
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        // Configuración para fragmento de navegación en listado
        model.addAttribute("pagina_actual", "Catálogo de Productos");

        return "productos/listado";
    }

    // Detalle de un producto
    @GetMapping("/{id}/{nombre}")
    public String detalle(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id);

        if (producto == null) {
            return "redirect:/productos";
        }
        model.addAttribute("producto", producto);

        // Datos para las migas de pan (breadcrumb)
        model.addAttribute("pagina_actual", producto.getNombre());
        model.addAttribute("ruta_padre", "/productos");
        model.addAttribute("nombre_padre", "Catálogo");

        return "productos/detalle";
    }
}
