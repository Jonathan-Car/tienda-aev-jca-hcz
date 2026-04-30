package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sobre-nosotros")
    public String sobreNosotros(Model model) {
        // Variables para fragmento (migas de pan públicas de partes.html)
        model.addAttribute("pagina_actual", "Sobre Nosotros");
        model.addAttribute("ruta_padre", "/");
        model.addAttribute("nombre_padre", "Inicio");
        return "sobre-nosotros";
    }
}
