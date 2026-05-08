package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generarTokken(UserDetails userDetails, TokenType type);
    String extraerUsuario(String token);
    boolean tokkenValido(String token, UserDetails userDetails);
    String extraerClaim(String token, String claimName);
}
