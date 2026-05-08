package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.controllers.advice;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.exceptions.StockInsuficienteException;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.exceptions.ProductoNoEncontradoException;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.exceptions.UnidadesInvalidasException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public org.springframework.http.ProblemDetail handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
        org.springframework.http.ProblemDetail problemDetail = org.springframework.http.ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Producto no encontrado");
        problemDetail.setType(URI.create("https://tienda.com/errors/not-found"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(StockInsuficienteException.class)
    public org.springframework.http.ProblemDetail handleConflictoCarrito(StockInsuficienteException ex) {
        org.springframework.http.ProblemDetail problemDetail = org.springframework.http.ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Conflicto en la operación del carrito");
        problemDetail.setType(URI.create("https://tienda.com/errors/conflict"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(UnidadesInvalidasException.class)
    public org.springframework.http.ProblemDetail handleUnidadesInvalidas(UnidadesInvalidasException ex) {
        org.springframework.http.ProblemDetail problemDetail = org.springframework.http.ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setTitle("Petición incorrecta");
        problemDetail.setType(URI.create("https://tienda.com/errors/bad-request"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}