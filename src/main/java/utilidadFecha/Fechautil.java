package utilidadFecha;

import java.util.Calendar;

public class Fechautil {
	
	public static void asignarTiempoCero(Calendar fecha) {
		fecha.set(Calendar.HOUR, 0);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
	}

}
