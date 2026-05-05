package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IUsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/profile")
    public String verPerfilPropio(Authentication authentication) {
        String email = authentication.getName();
        Usuario usuario = usuarioService.findByEmail(email);
        return "redirect:/users/profile/" + usuario.getId();
    }

    @GetMapping("/profile/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.usuario.id")
    public String verPerfilPorId(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de " + usuario.getNombre());

        return "usuarios/perfil";
    }
}