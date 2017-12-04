package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import util.FestivosColombia;

public class CalculoDeDiasDeVacaciones {

	private static  List<Calendar> diasFestivosDeUnAnio = new ArrayList<>();
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

	public static void obtenerFestivosDelAnioDesolicitud(SolicitudVacaciones solicitudVacaciones) {
		getDiasFestivosDeUnAnio().clear();
		setDiasFestivosDeUnAnio(FestivosColombia.diasFestivos(anioDeSolicitud(solicitudVacaciones)));
		
	}

	public static int anioDeSolicitud(SolicitudVacaciones solicitudVacaciones) {
		return solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);
	}

	private void contarDiasHabiles(SolicitudVacaciones solicitudVacaciones) {
		Calendar fechaSolicitudFinVaciones = solicitudVacaciones.getFechaDeSolicitudFin();
		Calendar fechaDeRegreso = crearFechaDeRegreso(solicitudVacaciones);
		int diasDeVacaciones = 0;
		int diaDeLaSemana;
		while (periodoDeVacaciones(fechaSolicitudFinVaciones, fechaDeRegreso, diasDeVacaciones)) {
			diaDeLaSemana = fechaDeRegreso.get(Calendar.DAY_OF_WEEK);
			if (diaHabil(fechaDeRegreso, diaDeLaSemana)) {
				diasDeVacaciones++;
			}
			fechaDeRegreso.add(Calendar.DAY_OF_YEAR, DIA_VACACION);
			verificarCambioDeAnioParaFestivos(fechaDeRegreso, solicitudVacaciones);
		}
		diaDeLaSemana = fechaDeRegreso.get(Calendar.DAY_OF_WEEK);
		verificarFechaRegresoParaDiaHabil(fechaDeRegreso, diaDeLaSemana);
		verificarQueRegresoNoESFestivo(fechaDeRegreso);
		solicitudVacaciones.setCantidadDeDias(diasDeVacaciones);
		solicitudVacaciones.setFechaDeRegreso(fechaDeRegreso);

	}

	public Calendar crearFechaDeRegreso(SolicitudVacaciones solicitudVacaciones) {
		Calendar fechaDeRegreso =Calendar.getInstance();
		int anio =solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);
		int mes= solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.MONTH);
		int dia= solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.DAY_OF_MONTH);
		fechaDeRegreso.set(anio, mes,dia);
		return fechaDeRegreso;
	}

	public boolean periodoDeVacaciones(Calendar fechaSolicitudFinVaciones, Calendar fechaDeRegreso,
			int diasDeVacaciones) {
		return (fechaDeRegreso.getTimeInMillis() <= fechaSolicitudFinVaciones.getTimeInMillis())
				&& diasDeVacaciones != MAXIMO_DIAS_VACACIONES;
	}

	public boolean diaHabil(Calendar fechaDeRegreso, int diaDeLaSemana) {
		return !(diaDeLaSemana == Calendar.SATURDAY || diaDeLaSemana == Calendar.SUNDAY)
				&& !esFestivo(fechaDeRegreso);
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

		
	}

	public void verificarQueRegresoNoESFestivo(Calendar fechaDeRegreso) {
		while(esFestivo(fechaDeRegreso)) {
			calcularFechaDeRegreso(fechaDeRegreso, UN_DIA_DESPUES);
		}
	}

	public void calcularFechaDeRegreso(Calendar fechaDeRegreso,int diasAnadidos) {
		fechaDeRegreso.add(Calendar.DAY_OF_YEAR, diasAnadidos);
	}

	private boolean esFestivo(Calendar fechaDeRegreso) {
		return FestivosColombia.esfestivo(getDiasFestivosDeUnAnio(), fechaDeRegreso);
	}

	public static List<Calendar> getDiasFestivosDeUnAnio() {
		return diasFestivosDeUnAnio;
	}

	public static void setDiasFestivosDeUnAnio(List<Calendar> diasFestivosDeUnAnio) {
		CalculoDeDiasDeVacaciones.diasFestivosDeUnAnio = diasFestivosDeUnAnio;
	}

	public void verificarCambioDeAnioParaFestivos(Calendar fechaDeRegreso,SolicitudVacaciones solicitudVacaciones){
		int anioDeSolisitud = solicitudVacaciones.getFechaDeSolicitudDeinicio().get(Calendar.YEAR);
		int anioDeDiaDeVacacion=fechaDeRegreso.get(Calendar.YEAR);
		if(anioDeDiaDeVacacion!=anioDeSolisitud){
			diasFestivosDeUnAnio.clear();
			diasFestivosDeUnAnio=FestivosColombia.diasFestivos(anioDeDiaDeVacacion);
		}
	}
}
