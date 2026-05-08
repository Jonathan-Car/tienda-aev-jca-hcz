package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.repositories;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.CarritoItem;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
    Optional<CarritoItem> findByUsuarioAndProducto(Usuario usuario, Producto producto);
    List<CarritoItem> findByUsuario(Usuario usuario);
    void deleteByUsuario(Usuario usuario);

    @Query("SELECT COUNT(DISTINCT c.producto) FROM CarritoItem c WHERE c.usuario = :usuario")
    long countDistinctProductosByUsuario(Usuario usuario);

    @Query("SELECT SUM(c.unidades) FROM CarritoItem c WHERE c.usuario = :usuario")
    Integer sumUnidadesByUsuario(Usuario usuario);

    @Query("SELECT SUM(c.unidades * c.producto.precio) FROM CarritoItem c WHERE c.usuario = :usuario")
    Double sumImporteTotalByUsuario(Usuario usuario);
}
