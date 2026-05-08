package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    // Hereda findAll(), findById()... (JpaRepository).
    // Consulta derivada: busca por ID categoría dentro de la lista de categorías
    List<Producto> findByCategorias_Id(Long id, Sort sort);
}
