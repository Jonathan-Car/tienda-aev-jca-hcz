package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
 @RequestMapping("/admin/productos")
public class ProductoAdminController {
    private final IProductoService productoService;

    public ProductoAdminController(IProductoService productoService, IMarcaService marcaService){
        this.productoService = productoService;
    }

    @GetMapping("/")
    public String redireccion(){
        return "redirect:/admin/productos";
    }
    @GetMapping("")
    public String lista(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "admin/productos/lista";
    }
    @GetMapping("/nuevo")
    public String nuevoProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "admin/productos/formulario";
    }

}
