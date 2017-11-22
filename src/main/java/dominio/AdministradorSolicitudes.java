package dominio;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

public class AdministradorSolicitudes {

	@Autowired
	CalculoDeDiasDeVacaciones calculoDeDiasDeVacaciones ;
	
	
	public SolicitudVacaciones ingresar(Calendar fechainicial,Calendar fechafinal,String nombrejefe) {
		
	SolicitudVacaciones solicitud= new SolicitudVacaciones(fechainicial, fechafinal, nombrejefe);
	CalculoDeDiasDeVacaciones calculo = new CalculoDeDiasDeVacaciones();
	calculo.calcularDias(solicitud);
 	return solicitud;
	
	}

}
