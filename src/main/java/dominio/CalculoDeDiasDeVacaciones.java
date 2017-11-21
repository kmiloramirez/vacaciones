package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import util.Fechautil;
import util.FestivosColombia;

public class CalculoDeDiasDeVacaciones {

	public ArrayList<Calendar> diasFestivosDeUnAnio = new ArrayList<>();
	public static final int MAXIMO_DIAS_VACACIONES = 15;
	public static final int DIA_VACACION = 1;
	public static final int DOS_DIAS_DESPUES = 2;
	public static final int UN_DIA_DESPUES = 1;
	public static final int CERO_DIAS_DESPUES = 0;

	public SolicitudVacaciones calcularDias(SolicitudVacaciones solicitudVacaciones) {
		obtenerFestivosDelAnioDesolicitud(solicitudVacaciones);
		contarDiasHabiles(solicitudVacaciones);
		return solicitudVacaciones;

	}

	private void contarDiasHabiles(SolicitudVacaciones solicitudVacaciones) {
		Calendar fechaMaximaDeRegreso = solicitudVacaciones.getFechaDeSolicitudDeinicio();
		Calendar fechaDesolicitudDeRegreso = solicitudVacaciones.getFechaDeSolicitudFin();
		int diasDeVacaciones = 0;
		Fechautil.asignarTiempoCero(fechaDesolicitudDeRegreso);
		Fechautil.asignarTiempoCero(fechaMaximaDeRegreso);
		while (!(fechaMaximaDeRegreso.equals(fechaDesolicitudDeRegreso)) && diasDeVacaciones < MAXIMO_DIAS_VACACIONES) {
			if (diaHabil(fechaMaximaDeRegreso)) {
				diasDeVacaciones++;
			}
			fechaMaximaDeRegreso.add(fechaMaximaDeRegreso.DAY_OF_YEAR, DIA_VACACION);
		}
		calcularFechaRealDeRegreso(solicitudVacaciones, fechaMaximaDeRegreso, diasDeVacaciones);
	}

	public void calcularFechaRealDeRegreso(SolicitudVacaciones solicitudVacaciones, Calendar fechaMaximaDeRegreso,
			int diasDeVacaciones) {
		Fechautil.asignarTiempoCero(fechaMaximaDeRegreso);
		solicitudVacaciones.setCantidadDeDias(diasDeVacaciones);
		if (fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			aumentarDias(solicitudVacaciones, fechaMaximaDeRegreso, DOS_DIAS_DESPUES);
		} else if (fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			aumentarDias(solicitudVacaciones, fechaMaximaDeRegreso, UN_DIA_DESPUES);
		} else {
			aumentarDias(solicitudVacaciones, fechaMaximaDeRegreso, CERO_DIAS_DESPUES);
		}
	}

	public void aumentarDias(SolicitudVacaciones solicitudVacaciones, Calendar fechaMaximaDeRegreso,
			int diasAAUmentar) {
		fechaMaximaDeRegreso.add(fechaMaximaDeRegreso.DAY_OF_YEAR, diasAAUmentar);
		if(noEsUnDiaFestivo(fechaMaximaDeRegreso)){
			solicitudVacaciones.setFechaDeRegreso(fechaMaximaDeRegreso);
		}
		else{
			fechaMaximaDeRegreso.add(fechaMaximaDeRegreso.DAY_OF_YEAR, UN_DIA_DESPUES);
		}
	}

	public boolean diaHabil(Calendar fechaMaximaDeRegreso) {
		return esUnDiaEntreLunesYViernes(fechaMaximaDeRegreso) && noEsUnDiaFestivo(fechaMaximaDeRegreso);
	}

	public boolean noEsUnDiaFestivo(Calendar fechaMaximaDeRegreso) {
		return !FestivosColombia.esfestivo(diasFestivosDeUnAnio, fechaMaximaDeRegreso);
	}

	public boolean esUnDiaEntreLunesYViernes(Calendar fechaMaximaDeRegreso) {
		return (fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
				&& fechaMaximaDeRegreso.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY);
	}

	public void obtenerFestivosDelAnioDesolicitud(SolicitudVacaciones solicitudVacaciones) {
		diasFestivosDeUnAnio.clear();
		diasFestivosDeUnAnio = FestivosColombia.diasFestivos(anioDeSolicitud(solicitudVacaciones));
	}

	public int anioDeSolicitud(SolicitudVacaciones solicitudVacaciones) {
		return solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);
	}

}
