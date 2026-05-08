package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String usuario;
    private String password;
}
