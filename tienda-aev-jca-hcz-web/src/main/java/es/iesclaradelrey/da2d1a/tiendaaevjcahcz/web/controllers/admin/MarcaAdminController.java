package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/marcas")
public class MarcaAdminController {

    private final IMarcaService marcaService;

    @Autowired
    public MarcaAdminController( IMarcaService marcaService) {
        this.marcaService = marcaService;
    }
    @GetMapping("")
    public String lista(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        return "admin/marcas/lista";
    }
    @GetMapping("/")
    public String marcaRedirigida() {
        return "redirect:/admin/marcas";
    }
    @GetMapping("/nueva")
    public String nuevaMarca(Model model) {
        model.addAttribute("marca",new Marca() );
        return "admin/marcas/formulario";
    }
    @GetMapping("/{id}/editar")
    public String editarMarca(@PathVariable("id") Long id, Model model) {
        model.addAttribute("marca", marcaService.findById(id));
        return "admin/marcas/formulario";
    }
    @PostMapping("/guardar")
    public String guardarMarca(@ModelAttribute("marca") Marca marca, Model model) {
        try{
            marcaService.save(marca);
            return "redirect:/admin/marcas";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "admin/marcas/formulario";
        }
    }
    @GetMapping("/{id}/borrar")
    public String confirmarBorrar(@PathVariable Long id, Model model) {
        model.addAttribute("marca", marcaService.findById(id));
        return "admin/marcas/borrar";
    }
    @PostMapping ("/{id}/borrar")
    public String eliminarMarca(@PathVariable Long id) {
        marcaService.deleteById(id);
        return "redirect:/admin/marcas";
    }
}
