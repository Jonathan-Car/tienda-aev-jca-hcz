package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(
        scanBasePackages = "es.iesclaradelrey.da2d1a.tiendaaevjcahcz",
        exclude = { org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class }
)
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
