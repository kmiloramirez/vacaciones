package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import utilidadFecha.FestivosColombia;

public class CalculoDeDiasDeVacaciones {
	
	public List<Calendar> diasFestivosDeUnAnio=new ArrayList<>();
	public static final int MAXIMO_DIAS_VACACIONES = 15;
	
	public SolicitudVacaciones CalcularDias (SolicitudVacaciones solicitudVacaciones){
		obtenerFestivosDelAnioDesolicitud(solicitudVacaciones);
		contarDiasHabiles(solicitudVacaciones);
		return solicitudVacaciones;
		
	}


	private void contarDiasHabiles(SolicitudVacaciones solicitudVacaciones) {
		Calendar fechaMaximaDeRegreso = solicitudVacaciones.getFechaDeSolicitudDeinicio();
		Calendar fechaDesolicitudDeRegreso =solicitudVacaciones.getFechaDeSolicitudFin();
		int diasDeVacaciones=0;
		while((fechaMaximaDeRegreso!=fechaDesolicitudDeRegreso)&&diasDeVacaciones<=MAXIMO_DIAS_VACACIONES){
			
			if(diaHabil(fechaMaximaDeRegreso)){
				diasDeVacaciones++;
			}
						
			
		}
		
	}


	public boolean diaHabil(Calendar fechaMaximaDeRegreso) {
		return fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK)<0 && fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK)>6;
	}


	public void obtenerFestivosDelAnioDesolicitud(SolicitudVacaciones solicitudVacaciones) {
		diasFestivosDeUnAnio.clear();
		diasFestivosDeUnAnio=FestivosColombia.DiasFestivos(anioDeSolicitud(solicitudVacaciones));
	}


	public int anioDeSolicitud(SolicitudVacaciones solicitudVacaciones) {
		return  solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);
		
	}

}
