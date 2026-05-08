package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.CarritoListadoDto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.services.CarritoService;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;
    private final UsuarioRepository usuarioRepository;

    private Usuario getUsuarioDesdeAuth(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + email));
    }

    @GetMapping
    public ResponseEntity<CarritoListadoDto> verCarrito(Authentication authentication) {
        Usuario usuario = getUsuarioDesdeAuth(authentication);
        return ResponseEntity.ok(carritoService.obtenerCarrito(usuario));
    }

    @PostMapping
    public ResponseEntity<CarritoListadoDto> añadirProducto(
            @RequestParam Long productId,
            @RequestParam Integer units,
            Authentication authentication) {
        Usuario usuario = getUsuarioDesdeAuth(authentication);
        return ResponseEntity.ok(carritoService.agregarProducto(usuario, productId, units));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<CarritoListadoDto> eliminarProducto(
            @PathVariable Long productId,
            Authentication authentication) {
        Usuario usuario = getUsuarioDesdeAuth(authentication);
        return ResponseEntity.ok(carritoService.eliminarProducto(usuario, productId));
    }

    @DeleteMapping
    public ResponseEntity<CarritoListadoDto> vaciarCarrito(Authentication authentication) {
        Usuario usuario = getUsuarioDesdeAuth(authentication);
        return ResponseEntity.ok(carritoService.vaciarCarrito(usuario));
    }
}