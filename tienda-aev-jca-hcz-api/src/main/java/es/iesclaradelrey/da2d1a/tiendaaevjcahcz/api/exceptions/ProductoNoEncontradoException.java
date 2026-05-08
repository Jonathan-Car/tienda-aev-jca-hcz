package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.exceptions;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(Long id) {
        super("No se ha encontrado el producto con ID: " + id);
    }
}