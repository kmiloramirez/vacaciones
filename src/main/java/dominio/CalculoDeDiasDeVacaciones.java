package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import utilidadFecha.FestivosColombia;

public class CalculoDeDiasDeVacaciones {
	
	private ArrayList<Calendar> diasFestivosDeUnAnio=new ArrayList<>();
	
	
	public SolicitudVacaciones CalcularDias (SolicitudVacaciones solicitudVacaciones){
		obtenerFestivosDelAnioDesolicitud(solicitudVacaciones);
		
		
		
		return solicitudVacaciones;
		
	}


	public void obtenerFestivosDelAnioDesolicitud(SolicitudVacaciones solicitudVacaciones) {
		diasFestivosDeUnAnio.clear();
		diasFestivosDeUnAnio=FestivosColombia.DiasFestivos(anioDeSolicitud(solicitudVacaciones));
	}


	public int anioDeSolicitud(SolicitudVacaciones solicitudVacaciones) {
		int anioDeSolicitud= solicitudVacaciones.getFechaDeSolicitudDeinicio().YEAR;
		return anioDeSolicitud;
	}

}
