package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "es.iesclaradelrey.da2d1a.tiendaaevjcahcz")
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a.tiendaaevjcahcz")
@EnableJpaRepositories(basePackages = {
        "es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories",
        "es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.repositories"
})
public class TiendaApiApp {
    public static void main(String[] args) {
        SpringApplication.run(TiendaApiApp.class, args);
    }
}