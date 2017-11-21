package dominio;

import java.util.Calendar;

public class SolicitudVacacionesDTO {
	Calendar fechaInicial;
	Calendar fechaFinal;
	String jefeInmediato;
	
	public Calendar getFechaInicial() {
		return fechaInicial;
	}
	public Calendar getFechaFinal() {
		return fechaFinal;
	}
	public String getJefeInmediato() {
		return jefeInmediato;
	}

	
	
	
}
