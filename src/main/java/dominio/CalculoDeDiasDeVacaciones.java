package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import utilidadFecha.Fechautil;
import utilidadFecha.FestivosColombia;


public class CalculoDeDiasDeVacaciones {

	public ArrayList<Calendar> diasFestivosDeUnAnio = new ArrayList<>();
	public static final int MAXIMO_DIAS_VACACIONES = 15;
	public static final int DIA_VACACION = 1;

	public SolicitudVacaciones CalcularDias(SolicitudVacaciones solicitudVacaciones) {
		obtenerFestivosDelAnioDesolicitud(solicitudVacaciones);
		contarDiasHabiles(solicitudVacaciones);
		return solicitudVacaciones;

	}

	private void contarDiasHabiles(SolicitudVacaciones solicitudVacaciones) {
		Calendar fechaMaximaDeRegreso = solicitudVacaciones.getFechaDeSolicitudDeinicio();
		Calendar fechaDesolicitudDeRegreso = solicitudVacaciones.getFechaDeSolicitudFin();
		int diasDeVacaciones = 0;
		while ((fechaMaximaDeRegreso != fechaDesolicitudDeRegreso) && diasDeVacaciones <= MAXIMO_DIAS_VACACIONES) {
			if (diaHabil(fechaMaximaDeRegreso)) {
				diasDeVacaciones++;
			}
			fechaMaximaDeRegreso.add(fechaMaximaDeRegreso.DAY_OF_YEAR, DIA_VACACION );
		}
		Fechautil.asignarTiempoCero(fechaMaximaDeRegreso);
		solicitudVacaciones.setCantidadDeDias(diasDeVacaciones);
		solicitudVacaciones.setFechaDeRegreso(fechaMaximaDeRegreso);
	}

	public boolean diaHabil(Calendar fechaMaximaDeRegreso) {
		return esUnDiaEntreLunesYViernes(fechaMaximaDeRegreso) && noEsUnDiaFestivo(fechaMaximaDeRegreso);
	}

	public boolean noEsUnDiaFestivo(Calendar fechaMaximaDeRegreso) {
		return !FestivosColombia.esfestivo(diasFestivosDeUnAnio, fechaMaximaDeRegreso);
	}

	public boolean esUnDiaEntreLunesYViernes(Calendar fechaMaximaDeRegreso) {
		return (fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY&&fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY);
	}

	public void obtenerFestivosDelAnioDesolicitud(SolicitudVacaciones solicitudVacaciones) {
		diasFestivosDeUnAnio.clear();
		diasFestivosDeUnAnio = FestivosColombia.DiasFestivos(anioDeSolicitud(solicitudVacaciones));
	}

	public int anioDeSolicitud(SolicitudVacaciones solicitudVacaciones) {
		return solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);

	}

}
