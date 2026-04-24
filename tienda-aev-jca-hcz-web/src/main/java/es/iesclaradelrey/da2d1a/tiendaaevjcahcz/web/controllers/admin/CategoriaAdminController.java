package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final ICategoriaService categoriaService;
    public CategoriaAdminController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String listaRedirigidas() {
        return "redirect:/admin/categorias";
    }

    @GetMapping("")
    public String lista(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "admin/categorias/lista";
    }
    @GetMapping("/nueva")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categorias/formulario";
    }

    @GetMapping("/{id}/editar")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        model.addAttribute("categoria", categoria);
        return "admin/categorias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("categoria") Categoria categoria ,Model model) {
        try{
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        }catch(Exception e){
            model.addAttribute("error", "Error al guardar: " + e.getMessage());
            return "admin/categorias/formulario";
        }
    }

    @GetMapping("/{id}/borrar")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        model.addAttribute("categoria", categoria);
        return "admin/categorias/borrar";
    }

    @PostMapping("/{id}/borrar")
    public String eliminar(@PathVariable Long id, Model model) {
        try {
            categoriaService.deleteById(id);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar: " + e.getMessage());
            model.addAttribute("categoria", categoriaService.findById(id));
            return "admin/categorias/borrar";
        }
    }
}
