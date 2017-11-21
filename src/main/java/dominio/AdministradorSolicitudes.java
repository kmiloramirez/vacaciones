package dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
@EnableAutoConfiguration
public class AdministradorSolicitudes {

	@Autowired
	CalculoDeDiasDeVacaciones calculoDeDiasDeVacaciones ;
	
	
	public static SolicitudVacaciones ingresar(SolicitudVacacionesDTO solicitudDto) {
		
	SolicitudVacaciones solicitud= new SolicitudVacaciones(solicitudDto.getFechaInicial(), solicitudDto.getFechaFinal(), solicitudDto.getJefeInmediato());
	
 	return solicitud;
	
	}

}
