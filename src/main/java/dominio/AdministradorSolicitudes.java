package dominio;

import org.springframework.beans.factory.annotation.Autowired;

public class AdministradorSolicitudes {

	@Autowired
	CalculoDeDiasDeVacaciones calculoDeDiasDeVacaciones ;
	
	
	public SolicitudVacaciones ingresar(SolicitudVacacionesDTO solicitudDto) {
		
	SolicitudVacaciones solicitud= new SolicitudVacaciones(solicitudDto.getFechaInicial(), solicitudDto.getFechaFinal(), solicitudDto.getJefeInmediato());
	calculoDeDiasDeVacaciones.calcularDias(solicitud);
 	return solicitud;
	
	}

}
