package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.security.service;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUserDetails implements UserDetails {

    private final Usuario usuario;

    public SecurityUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // lista para guardar las autoridades de Spring Security
        java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority> authorities = new java.util.ArrayList<>();
        // Recorre los roles de entidad Usuario
        for (es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Rol rol : usuario.getRoles()) {

            //Convertimos cada Rol en una SimpleGrantedAuthority
            authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + rol.getId()));
        }

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}