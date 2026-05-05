package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configuración para que la consola de H2 funcione
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )
                // Reglas de Autorización
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").authenticated() // H2 requiere login
                        .requestMatchers("/admin/**").authenticated()      // Admin requiere login
                        .anyRequest().permitAll()                          // El resto (tienda) es público
                )
                // Configuración del Login y Logout
                .formLogin(form -> form
                        .permitAll() // Habilita el formulario por defecto de Spring
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/") // Al salir, volvemos a la tienda
                )
                // Desactivar HTTP Basic como pide el PDF
                .httpBasic(basic -> basic.disable())

                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                );

        return http.build();
    }
}