package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final ICategoriaService categoriaService;
    public CategoriaAdminController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("")
    public String listaRedirigidas() {
        return "redirect:/admin/categorias";
    }
    @GetMapping("")
    public String lista(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "admin/categorias/lista";
    }

}
