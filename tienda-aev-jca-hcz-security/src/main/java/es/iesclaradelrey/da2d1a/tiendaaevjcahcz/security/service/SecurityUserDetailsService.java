package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.security.service;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado el usuario con email: " + email));

        return new SecurityUserDetails(usuario);
    }
}