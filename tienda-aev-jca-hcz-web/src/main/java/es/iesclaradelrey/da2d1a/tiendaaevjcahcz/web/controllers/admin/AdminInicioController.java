package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminInicioController {
    @GetMapping("")
    public String inicio(){
        return "admin/index";
    }
    @GetMapping("/")
        String indexRedirigir(){
            //index del admin
            return "redirect:/admin";
        }

}
