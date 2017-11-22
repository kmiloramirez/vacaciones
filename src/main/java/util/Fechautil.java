package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fechautil {
	
	public static Calendar asignarTiempoCero(Calendar fecha) {
		fecha.set(Calendar.HOUR, 0);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
		return fecha;
	}

	public static Calendar dateToCalendar(Date date )
	{
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  cal.setTimeInMillis(cal.getTimeInMillis()+18000000);
	  return cal;
	 }

}
