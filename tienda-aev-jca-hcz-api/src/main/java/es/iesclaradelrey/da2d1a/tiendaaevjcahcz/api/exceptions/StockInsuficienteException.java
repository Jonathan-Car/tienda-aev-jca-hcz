package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.exceptions;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}