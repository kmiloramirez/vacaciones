package util;

import java.util.Calendar;

public class Fechautil {
	
	public static Calendar asignarTiempoCero(Calendar fecha) {
		fecha.set(Calendar.HOUR, 0);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
		return fecha;
	}

	public static Calendar setearFecha(Calendar fecha,int anio,int mes,int dia) {
		asignarTiempoCero(fecha);
		fecha.set(Calendar.YEAR, anio );
		fecha.set(Calendar.MONTH, mes);
		fecha.set(Calendar.DAY_OF_MONTH,dia);
		return fecha;
	}

}
