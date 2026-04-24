package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IMarcaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/marcas")
public class MarcaAdminController {
    private IMarcaRepository marcaRepository;

    @GetMapping("/")
    public String marcaRedirigida() {
        return "redirect:/admin/marcas";
    }
}
