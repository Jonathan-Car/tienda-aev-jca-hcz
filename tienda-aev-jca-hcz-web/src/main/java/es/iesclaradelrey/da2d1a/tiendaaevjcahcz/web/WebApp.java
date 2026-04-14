package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {
        // Escaneo para encontrar controladores y vistas
        "es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web",

        // Escanea el common para que encuentre los @Service y el @Repository
        "es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common"
})
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
