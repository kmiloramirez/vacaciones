package util;


import java.util.Calendar;
import java.util.Date;

public class Fechautil {
	
	public Fechautil() {
		super();
		
	}

	public static Calendar asignarTiempoCero(Calendar fecha) {
		fecha.set(Calendar.HOUR, 0);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
		return fecha;
	}

	public static Calendar dateToCalendarColombianZone(Date date )
	{
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  cal.add(Calendar.DAY_OF_YEAR, 1);
	  return cal;
	 }

}
