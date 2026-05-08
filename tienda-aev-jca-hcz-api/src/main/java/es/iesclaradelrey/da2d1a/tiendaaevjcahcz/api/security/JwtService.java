package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails userDetails, TokenType type);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    String extractClaim(String token, String claimName);
}
