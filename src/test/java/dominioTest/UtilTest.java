package dominioTest;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import util.Fechautil;

public class UtilTest {
	Calendar fechaPrueba=Calendar.getInstance();

	@Test
	public void establecerHoraCerotest() {
		fechaPrueba.set(Calendar.HOUR, 0);
		fechaPrueba.set(Calendar.MINUTE, 0);
		fechaPrueba.set(Calendar.SECOND, 0);
		fechaPrueba.set(Calendar.MILLISECOND, 0);
		
		assertEquals(Fechautil.asignarTiempoCero(fechaPrueba), fechaPrueba);
		
	}

}
