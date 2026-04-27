package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IMarcaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("admin/marcas")
public class MarcaAdminController {
    private IMarcaRepository marcaRepository;

    @GetMapping("/")
    public String marcaRedirigida() {
        return "redirect:/admin/marcas";
    }
    @GetMapping("/nueva")
    public String nuevaMarca(Model model) {
        model.addAttribute("marca", marcaService.findALl());
        return "admin/marcas/formulario";
    }
    @PostMapping("/{id}/editar")
    public String editarMarca(@PathVariable("id") Long id, Model model) {
        model.addAttribute("marca", marcaService.findById(id));
        return "admin/marcas/formulario";
    }
    @PostMapping("/guardar")
    public String guardarMarca(@ModelAttribute("marca") Model model, Marca marca) {

    }
}
