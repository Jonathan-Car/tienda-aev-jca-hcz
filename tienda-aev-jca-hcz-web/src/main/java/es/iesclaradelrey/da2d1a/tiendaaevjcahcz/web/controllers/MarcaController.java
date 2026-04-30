package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IMarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private final IMarcaService marcaService;

    public MarcaController(IMarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable("id") Long id, Model model) {
        // Buscar la marca por ID
        Marca marca = marcaService.findById(id);

        // Ordena alfabéticamente
        List<Producto> productos = marcaService.obtenerProductosDeMarca(id);

        // Añadir al modelo
        model.addAttribute("marca", marca);
        model.addAttribute("productos", productos);

        // Datos para las migas de pan (partes.html)
        model.addAttribute("pagina_actual", "Productos de " + marca.getNombre());
        model.addAttribute("ruta_padre", "/"); // O a un listado de marcas si lo tuvieras
        model.addAttribute("nombre_padre", "Inicio");

        // Devolver vista
        return "marcas/detail";
    }
}
