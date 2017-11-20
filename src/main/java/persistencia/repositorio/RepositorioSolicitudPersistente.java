package persistencia.repositorio;

import javax.persistence.EntityManager;
import dominio.SolicitudVacaciones;
import persistencia.builder.SolicitudBuilder;
import persistencia.entidad.SolicitudEntidad;
import repositorio.SolicitudVacacionesRepositorio;

public class RepositorioSolicitudPersistente implements SolicitudVacacionesRepositorio {

	private EntityManager entityManager;
	
	
	public RepositorioSolicitudPersistente(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public void insertar(SolicitudVacaciones solicitud) {	
			SolicitudEntidad solicitudentidad=SolicitudBuilder.convertirAEntity(solicitud);
			entityManager.persist(solicitudentidad);
			
		}


		
	}


