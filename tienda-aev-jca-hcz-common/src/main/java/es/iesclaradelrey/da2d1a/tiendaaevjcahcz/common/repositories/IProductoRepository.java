package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    // Hereda findAll(), findById()... (JpaRepository).
}
