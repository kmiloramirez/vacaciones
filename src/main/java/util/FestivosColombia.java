package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Fechautil;

public class FestivosColombia {
	private FestivosColombia() {
	}

	protected static final List<Calendar> diasFestivos = new ArrayList<>();
	public static final int DIA_LUNES = Calendar.MONDAY;
	public static final int DIA_JUEVES = Calendar.THURSDAY;
	public static final int DIA_VIERNES = Calendar.FRIDAY;
	public static final int DIA_DOMINGO = Calendar.SUNDAY;

	public static List<Calendar> diasFestivos(int anio) {
		diasFestivos.clear();
		Calendar pascua = calcularPascua(anio);
		Calendar diaFestivo = Calendar.getInstance();

		incluirFechaFestivaFija(anio, Calendar.JANUARY, 1);// primero de enero

		diaFestivo.set(anio, Calendar.JANUARY, 6); // reyes magos
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		diaFestivo.set(anio, Calendar.MARCH, 19);// san jose
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_DOMINGO, pascua, true, false)); // Domingo de Ramos

		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_JUEVES, pascua, true, true)); // Jueves Santo

		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_VIERNES, pascua, true, true)); // Viernes Santo

		incluirFechaVariablePorAnio(pascua); // Pascua

		incluirFechaFestivaFija(anio, Calendar.MAY, 1); // primero de mayo

		diaFestivo = siguienteDiaSemana(DIA_LUNES, pascua, false, true);
		diaFestivo.add(Calendar.DAY_OF_YEAR, 42);
		incluirFechaVariablePorAnio(diaFestivo); // Ascensión de Jesús

		diaFestivo = siguienteDiaSemana(DIA_LUNES, pascua, false, true);
		diaFestivo.add(Calendar.DAY_OF_YEAR, 63);
		incluirFechaVariablePorAnio(diaFestivo); // Corpus Christi

		diaFestivo = siguienteDiaSemana(DIA_LUNES, pascua, false, true);
		diaFestivo.add(Calendar.DAY_OF_YEAR, 70);
		incluirFechaVariablePorAnio(diaFestivo); // Sagrado Corazón

		diaFestivo.getTime();
		diaFestivo.set(anio, Calendar.JUNE, 29);// san pedro y pablo
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		incluirFechaFestivaFija(anio, Calendar.JULY, 20);// Independencia

		incluirFechaFestivaFija(anio, Calendar.AUGUST, 7); // batalla de boyaca

		diaFestivo.set(anio, Calendar.AUGUST, 15);// ascension de la virgen
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		diaFestivo.set(anio, Calendar.OCTOBER, 12);// dia de la raza
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		diaFestivo.set(anio, Calendar.NOVEMBER, 1);// todos los santos
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		diaFestivo.set(anio, Calendar.NOVEMBER, 11);// independencia cartagena
		incluirFechaVariablePorAnio(siguienteDiaSemana(DIA_LUNES, diaFestivo, false, true));

		incluirFechaFestivaFija(anio, Calendar.DECEMBER, 8);// inmaculada concepcion

		incluirFechaFestivaFija(anio, Calendar.DECEMBER, 25);// navdad

		return diasFestivos;

	}

	private static void incluirFechaVariablePorAnio(Calendar diaFestivo) {

		Calendar fechaAgregar = Calendar.getInstance();
		fechaAgregar.setTime(diaFestivo.getTime());

		Fechautil.asignarTiempoCero(fechaAgregar);
		diasFestivos.add(fechaAgregar);

	}

	private static Calendar calcularPascua(int anio) {
		int a;
		int b;
		int c;
		int d;
		int e;
		int m = 24;
		int n = 5;

		if (anio >= 1900 && anio <= 2099) {
			m = 24;
			n = 5;
		} else if (anio >= 2100 && anio <= 2199) {
			m = 24;
			n = 6;
		} else if (anio >= 2200 && anio <= 2299) {
			m = 25;
			n = 0;
		}

		a = anio % 19;
		b = anio % 4;
		c = anio % 7;
		d = ((a * 19) + m) % 30;
		e = ((2 * b) + (4 * c) + (6 * d) + n) % 7;

		int dia = d + e;

		Calendar inicioPascua = Calendar.getInstance();
		if (dia < 10) { // Marzo
			inicioPascua.set(anio, Calendar.MARCH, dia + 22);
			return inicioPascua;
		} else // Abril
		{

			if (dia == 26) {
				dia = 19;
			} else if (dia == 25 && d == 28 && e == 6 && a > 10) {
				dia = 18;
			} else {
				dia -= 9;
			}
			inicioPascua.set(anio, Calendar.APRIL, dia);
			return inicioPascua;
		}
	}

	private static Calendar siguienteDiaSemana(int diaSemana, Calendar fechaReferencia, boolean haciaAtras,
			boolean inclusive) {
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(fechaReferencia.getTime());
		if (inclusive) {
			if (fecha.get(Calendar.DAY_OF_WEEK) == diaSemana) {
				return fecha;
			}
		} else {
			if (haciaAtras) {
				fecha.add(Calendar.DAY_OF_YEAR, -1);
			} else {
				fecha.add(Calendar.DAY_OF_YEAR, 1);
			}
		}
		while (fecha.get(Calendar.DAY_OF_WEEK) != diaSemana) {
			if (haciaAtras) {
				fecha.add(Calendar.DAY_OF_YEAR, -1);
			} else {
				fecha.add(Calendar.DAY_OF_YEAR, 1);
			}
		}
		return fecha;
	}

	public static boolean esfestivo(List<Calendar> listafestivos, Calendar fechaFestiva) {
		Fechautil.asignarTiempoCero(fechaFestiva);
		for (int i = 0; i < listafestivos.size(); i++) {
			if (fechaFestiva.getTime().equals(listafestivos.get(i).getTime())) {
				return true;
			}
		}
		return false;

	}

	private static void incluirFechaFestivaFija(int anio, int mes, int dia) {
		Calendar fechaAgregar = Calendar.getInstance();
		fechaAgregar.set(anio, mes, dia);
		Fechautil.asignarTiempoCero(fechaAgregar);
		diasFestivos.add(fechaAgregar);
	}
}
