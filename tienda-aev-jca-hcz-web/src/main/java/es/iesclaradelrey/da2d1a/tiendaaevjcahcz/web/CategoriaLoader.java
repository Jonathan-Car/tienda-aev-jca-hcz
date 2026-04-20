package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services.ICategoriaService;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoriaLoader implements CommandLineRunner {
    private final ICategoriaService categoriaService;

    public CategoriaLoader(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;

    }
    @Override
    public void run(String... args) throws Exception {
        Categoria c1 = new Categoria(1L, "Moviles", "Los mejores moviles del mercado", "redmi13.png");

        Categoria c2 = new Categoria(2L, "Portatiles", "Portatiles perfectos para el gaming", "portatilDell.png");

        Categoria c3 = new Categoria(3L, "Perifericos", "Los mejores perifericos", null);

        Categoria c4 = new Categoria(4L, "Tablets", "Mejores tablets del mercado", "tablets.png");

        categoriaService.save(c1);
        categoriaService.save(c2);
        categoriaService.save(c3);
        categoriaService.save(c4);

        System.out.println("Cargando las categorias");
    }

}
