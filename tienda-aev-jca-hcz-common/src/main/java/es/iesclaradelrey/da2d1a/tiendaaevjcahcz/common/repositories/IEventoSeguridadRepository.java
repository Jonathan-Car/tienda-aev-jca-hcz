package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.EventoSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio asociado a entidad EventoSeguridad (11-3.1)
public interface IEventoSeguridadRepository extends JpaRepository<EventoSeguridad, Long> {

}
