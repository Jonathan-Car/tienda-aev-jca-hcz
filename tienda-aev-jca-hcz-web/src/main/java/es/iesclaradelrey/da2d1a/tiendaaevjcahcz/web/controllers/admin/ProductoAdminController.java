package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.ICategoriaService;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IMarcaService;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IProductoService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
 @RequestMapping("/admin/productos")
public class ProductoAdminController {
    private final IProductoService productoService;
    private final IMarcaService marcaService;
    private final ICategoriaService categoriaService;

    public ProductoAdminController(IProductoService productoService, IMarcaService marcaService,  ICategoriaService categoriaService) {
        this.productoService = productoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
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
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());

        return "admin/productos/formulario";

    }
    @GetMapping("/{id}/editar")
    public String editarProducto(@PathVariable("id") Long id,Model model){
        model.addAttribute("producto", productoService.findById(id));
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "admin/productos/formulario";
    }
    @PostMapping("/guardar")
    public String guardarProducto(@Valid @ModelAttribute("producto") Producto producto,
                                  BindingResult result,
                                  @RequestParam("archivoImagen") MultipartFile archivoImagen,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("marcas", marcaService.findAll());
            model.addAttribute("categorias", categoriaService.findAll());
            return "admin/productos/formulario";
        }

        try {
            productoService.save(producto, archivoImagen);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("marcas", marcaService.findAll());
            model.addAttribute("categorias", categoriaService.findAll());
            model.addAttribute("error", "Error crítico al procesar el producto: " + e.getMessage());
            return "admin/productos/formulario";
        }
    }
    @GetMapping("/{id}/borrar")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.findById(id));
        return "admin/productos/borrar";
    }

    @PostMapping("/{id}/borrar")
    public String eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos";
    }

}
