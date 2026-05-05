package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IUsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/profile")
    public String verPerfilPropio(Authentication authentication, Model model) {
        String email = authentication.getName();
        Usuario usuario = usuarioService.findByEmail(email);

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Mi Perfil de Usuario");

        return "usuarios/perfil";
    }
}