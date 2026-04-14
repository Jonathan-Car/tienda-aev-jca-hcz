package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
@GetMapping("/categorias") //url
public class CategoriaController {
    //inyeccion de la interfaz
    private final ICategoriaService categoriaService;
    //constructor
    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;

    }
    @GetMapping({"/", ""})
    public String listado(Model model) {
        //pedir las categorias
    }
}
