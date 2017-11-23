package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import util.Fechautil;
import util.FestivosColombia;

public class CalculoDeDiasDeVacaciones {

	public ArrayList<Calendar> diasFestivosDeUnAnio = new ArrayList<>();
	public static final int MAXIMO_DIAS_VACACIONES = 15;
	public static final int DIA_VACACION = 1;
	public static final int TRES_DIAS_DESPUES = 3;
	public static final int DOS_DIAS_DESPUES = 2;
	public static final int UN_DIA_DESPUES = 1;
	public static final int CERO_DIAS_DESPUES = 0;

	public SolicitudVacaciones calcularDias(SolicitudVacaciones solicitudVacaciones) {
		obtenerFestivosDelAnioDesolicitud(solicitudVacaciones);
		contarDiasHabiles(solicitudVacaciones);
		return solicitudVacaciones;

	}

	public void obtenerFestivosDelAnioDesolicitud(SolicitudVacaciones solicitudVacaciones) {
		diasFestivosDeUnAnio.clear();
		diasFestivosDeUnAnio = FestivosColombia.diasFestivos(anioDeSolicitud(solicitudVacaciones));
	}

	public int anioDeSolicitud(SolicitudVacaciones solicitudVacaciones) {
		return solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);
	}

	private void contarDiasHabiles(SolicitudVacaciones solicitudVacaciones) {
		Calendar fechaSolicitudFinVaciones = solicitudVacaciones.getFechaDeSolicitudFin();
		Calendar fechaDeRegreso = solicitudVacaciones.getFechaDeSolicitudDeinicio();
		int diasDeVacaciones = 0;
		int diaDeLaSemana;
		Fechautil.asignarTiempoCero(fechaSolicitudFinVaciones);
		Fechautil.asignarTiempoCero(fechaDeRegreso);
		while ((fechaDeRegreso.getTimeInMillis() <= fechaSolicitudFinVaciones.getTimeInMillis())
				&& diasDeVacaciones != MAXIMO_DIAS_VACACIONES) {
			diaDeLaSemana = fechaDeRegreso.get(Calendar.DAY_OF_WEEK);
			if (!(diaDeLaSemana == Calendar.SATURDAY || diaDeLaSemana == Calendar.SUNDAY)
					&& !esFestivo(fechaDeRegreso)) {
				diasDeVacaciones++;
			}
			fechaDeRegreso.add(fechaDeRegreso.DAY_OF_YEAR, DIA_VACACION);
		}
		diaDeLaSemana = fechaDeRegreso.get(Calendar.DAY_OF_WEEK);
		verificarFechaRegresoParaDiaHabil(fechaDeRegreso, diaDeLaSemana);
		solicitudVacaciones.setCantidadDeDias(diasDeVacaciones);
		solicitudVacaciones.setFechaDeRegreso(fechaDeRegreso);

	}

	public void verificarFechaRegresoParaDiaHabil(Calendar fechaDeRegreso, int diaDeLaSemana) {
		if (diaDeLaSemana == Calendar.SATURDAY) {
			calcularFechaDeRegreso(fechaDeRegreso,DOS_DIAS_DESPUES);
		}
		else if (diaDeLaSemana == Calendar.SUNDAY) {
			calcularFechaDeRegreso(fechaDeRegreso, UN_DIA_DESPUES);
		}
		else {
			calcularFechaDeRegreso(fechaDeRegreso, CERO_DIAS_DESPUES);
		}

		if (esFestivo(fechaDeRegreso)) {
			calcularFechaDeRegreso(fechaDeRegreso, UN_DIA_DESPUES);
		}
	}

	public void calcularFechaDeRegreso(Calendar fechaDeRegreso,int diasAnadidos) {
		fechaDeRegreso.add(fechaDeRegreso.DAY_OF_YEAR, diasAnadidos);
	}

	private boolean esFestivo(Calendar fechaDeRegreso) {
		return FestivosColombia.esfestivo(diasFestivosDeUnAnio, fechaDeRegreso);
	}

}
