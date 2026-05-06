package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.security;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.EventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.TipoEvento;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IEventoSeguridadRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadConfig {
    private final IEventoSeguridadRepository iEventoSeguridadRepository;

    public SeguridadConfig(IEventoSeguridadRepository iEventoSeguridadRepository) {
        this.iEventoSeguridadRepository = iEventoSeguridadRepository;
    }

    @Bean
    public SecurityFilterChain filtroSeguridad(HttpSecurity http) throws Exception {
        http
                // CONTROL DE ACCESO
                .authorizeHttpRequests(autorizar -> autorizar
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Solo admin
                        .anyRequest().permitAll() // resto es libre
                )

                // FORMULARIO DE LOGIN (11-3.3)
                .formLogin(formulario -> formulario
                        .loginPage("/login")
                        .failureUrl("/login?error=true") // Si falla, aviso
                        .permitAll()
                )

                // CIERRE DE SESIÓN (11-3.4)
                .logout(salir -> salir
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/") // Al salir, directo al Home
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                );

        return http.build();
    }
}
