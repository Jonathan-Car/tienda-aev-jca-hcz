package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.web.security;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.EventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.TipoEvento;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IEventoSeguridadRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class RegistroSeguridad {
    private final IEventoSeguridadRepository iEventoSeguridadRepository;

    public RegistroSeguridad(IEventoSeguridadRepository iEventoSeguridadRepository) {
        this.iEventoSeguridadRepository = iEventoSeguridadRepository;
    }

    // Evento que se dispara cuando usu completa login con éxito
    @EventListener
    public void conExito(AuthenticationSuccessEvent evento) {
        String usuario = evento.getAuthentication().getName();
        iEventoSeguridadRepository.save(new EventoSeguridad(usuario, TipoEvento.LOGIN));
    }

    @EventListener
    public void conError(AuthenticationFailureBadCredentialsEvent evento) {
        String usuario = (String) evento.getAuthentication().getPrincipal();
        iEventoSeguridadRepository.save(new EventoSeguridad(usuario, TipoEvento.LOGIN_ERROR));
    }
}
