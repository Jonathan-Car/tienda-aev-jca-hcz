package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;

public interface IUsuarioService {
    Usuario findByEmail(String email); // Necesario para login y perfil[cite: 1, 3]
    Usuario save(Usuario usuario);     // Necesario para el registro (PDF 9)[cite: 1]
    Usuario findById(Long id);         // Necesario para el perfil por ID (PDF 10)[cite: 3]
}
