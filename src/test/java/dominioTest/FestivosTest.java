package dominioTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import utilidadFecha.Fechautil;
import utilidadFecha.FestivosColombia;

public class FestivosTest {
	
	FestivosColombia festivos=new FestivosColombia();
	ArrayList<Calendar> listafestivos=FestivosColombia.DiasFestivos(2019);
	Calendar fechaDePrueba=Calendar.getInstance(); 
	@Test
	public void EsfestivoTest() {
		fechaDePrueba.set(2019,Calendar.APRIL,19);
		assertTrue(festivos.esfestivo(listafestivos,fechaDePrueba));
	}

	@Test
	public void noEsfestivoTest() {
		fechaDePrueba.set(2019,Calendar.APRIL,17);
		Fechautil.asignarTiempoCero(fechaDePrueba);
		assertFalse(festivos.esfestivo(listafestivos,fechaDePrueba));
	}

}
