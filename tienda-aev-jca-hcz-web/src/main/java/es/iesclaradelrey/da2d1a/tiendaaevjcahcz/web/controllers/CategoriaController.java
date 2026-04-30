package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import org.springframework.ui.Model;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.ICategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/categorias") //url
public class CategoriaController{
    //inyeccion de la interfaz
    private final ICategoriaService categoriaService;
    //constructor
    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping({"/", ""})
    public String listado(Model model) {
        // pedimos las categoría y las guardamos en una lista
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        //devolvemos el html de la lista
        return "categorias/list";
    }
    @GetMapping("/{id}")
    public String detalle(@PathVariable("id") Long id, Model model) {
        //buscamos la categoria por ID
        Categoria categoria = categoriaService.findById(id);
        // Ordena alfabéticamente
        model.addAttribute("productos", categoriaService.obtenerProductosDeCategoria(id));
        // añadimos al modelo la categoria
        model.addAttribute("categoria", categoria);
        //devolvemos el html de detalle
        return "categorias/detail";
    }
}