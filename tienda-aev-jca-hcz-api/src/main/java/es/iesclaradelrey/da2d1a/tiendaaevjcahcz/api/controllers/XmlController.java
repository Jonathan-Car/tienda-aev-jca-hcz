package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.services.IXmlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/xml")
public class XmlController {

    private final IXmlService xmlService;

    public XmlController(IXmlService xmlService) {
        this.xmlService = xmlService;
    }

    // 3.2 - Exportación de productos en formato XML usando DOM
    @GetMapping
    public void exportarProductos(HttpServletResponse response) throws Exception {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd.HH-mm"));
        String nombreFichero = "products-export." + fecha + ".xml";

        response.setContentType("application/xml;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreFichero + "\"");

        xmlService.exportarProductos(response.getOutputStream());
    }

    // 3.3 - Importación de productos desde fichero XML usando SAX
    @PostMapping
    public void importarProductos(@RequestParam("productsfile") MultipartFile productsfile) throws Exception {
        xmlService.importarProductos(productsfile.getInputStream());
    }
}