package persistencia.builder;

import dominio.SolicitudVacaciones;
import persistencia.entidad.SolicitudEntidad;

public class SolicitudBuilder {
	
	@SuppressWarnings("null")
	public static SolicitudVacaciones convertirADominio(SolicitudEntidad solicitudEntity) {
		if (solicitudEntity == null) {
			return null;
		}
			SolicitudVacaciones solicitud=null;
			solicitud.setCantidadDeDias(solicitudEntity.getCantidadDeDias());
			solicitud.setFechaDeRegreso(solicitudEntity.getFechaDeRegreso());
		return solicitud;
	}

	public static SolicitudEntidad convertirAEntity(SolicitudVacaciones solicitud) {
		SolicitudEntidad solicitudEntity = new SolicitudEntidad();
		solicitudEntity.setCantidadDeDias(solicitud.getCantidadDeDias());
		solicitudEntity.setFechaDeRegreso(solicitud.getFechaDeRegreso());
		solicitudEntity.setFechaDeSolicitudDeinicio(solicitud.getFechaDeSolicitudDeinicio());
		solicitudEntity.setFechaDeSolicitudFin(solicitud.getFechaDeSolicitudFin());
		solicitudEntity.setJefeInmediato(solicitud.getJefeInmediato());	
		return solicitudEntity;
	}


}
