package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Personalización de formulario (3.3)
@Controller
public class LoginController {
    // Atiende la petición en SeguridadConfig
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        // Busca login.html en templates
        return "login";
    }
}
