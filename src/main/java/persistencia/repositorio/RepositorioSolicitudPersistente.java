package persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dominio.SolicitudVacaciones;
import dominio.exepcion.VacacionesExepcion;
import persistencia.builder.SolicitudBuilder;
import persistencia.entidad.SolicitudEntidad;
import repositorio.SolicitudVacacionesRepositorio;

@Repository
public class RepositorioSolicitudPersistente implements SolicitudVacacionesRepositorio {

	@Autowired
	private EntityManager entityManager;
	private static final String JEFE_INMEDIATO ="jefeInmediato";
	private static final String TOTAL_SOLICITUDES_PENDIENTES = "Solicitud.BuscarSolicitudesPendientes";
	private static final String NO_EXISTEN_SLICITUDES = "no existen solisiudes pendientes";

	public RepositorioSolicitudPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void insertar(SolicitudVacaciones solicitud) {
		SolicitudEntidad solicitudentidad = SolicitudBuilder.convertirAEntity(solicitud);
		entityManager.persist(solicitudentidad);

	}

	@Override
	public List<SolicitudVacaciones> obtenerListaSolicitudVacaciones(String jefeInmediato) {

		List<SolicitudEntidad> listaEntidad = listarSolicitudes(jefeInmediato);
		if (listaEntidad != null) {
			List<SolicitudVacaciones> listaSolicitudDeVacaciones = new ArrayList<>();
			for (SolicitudEntidad entidad : listaEntidad) {
				listaSolicitudDeVacaciones.add(SolicitudBuilder.convertirADominio(entidad));
			}
			return listaSolicitudDeVacaciones;
		}
		throw new VacacionesExepcion(NO_EXISTEN_SLICITUDES);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<SolicitudEntidad> listarSolicitudes(String jefeInmediato) {
		Query query = entityManager.createNamedQuery(TOTAL_SOLICITUDES_PENDIENTES);
		query.setParameter(JEFE_INMEDIATO ,jefeInmediato);
		List resultList = query.getResultList();
		return !resultList.isEmpty() ? resultList : null;
	}

}
