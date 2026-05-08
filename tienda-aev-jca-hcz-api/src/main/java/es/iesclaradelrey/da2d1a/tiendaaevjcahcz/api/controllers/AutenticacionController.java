package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.controllers;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.LoginRequest;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.RefreshRequest;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos.TokenResponse;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.security.JwtService;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.security.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getPassword())
        );

        UserDetails usuario = userDetailsService.loadUserByUsername(request.getUsuario());

        String accessToken = jwtService.generarTokken(usuario, TokenType.ACCESS);
        String refreshToken = jwtService.generarTokken(usuario, TokenType.REFRESH);

        return ResponseEntity.ok(TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build());
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestBody RefreshRequest request) {
        String refreshToken = request.getRefreshToken();
        String nombreUsu = jwtService.extraerUsuario(refreshToken);

        if (nombreUsu != null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(nombreUsu);

            if (jwtService.tokkenValido(refreshToken, userDetails)) {
                String tipoTokken = jwtService.extraerClaim(refreshToken, "type");

                if (TokenType.REFRESH.name().equals(tipoTokken)) {
                    String nuevoAccesoTokken = jwtService.generarTokken(userDetails, TokenType.ACCESS);

                    return ResponseEntity.ok(TokenResponse.builder()
                            .accessToken(nuevoAccesoTokken)
                            .refreshToken(refreshToken)
                            .build());
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }
}