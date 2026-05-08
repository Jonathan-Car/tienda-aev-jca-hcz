package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.services;

import java.io.InputStream;
import java.io.OutputStream;

public interface IXmlService {
    void exportarProductos(OutputStream outputStream) throws Exception;
    void importarProductos(InputStream inputStream) throws Exception;
}
