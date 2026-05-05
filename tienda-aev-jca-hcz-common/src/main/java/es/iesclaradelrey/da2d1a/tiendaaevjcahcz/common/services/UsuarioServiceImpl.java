package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + email));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID de usuario no encontrado: " + id));
    }
}