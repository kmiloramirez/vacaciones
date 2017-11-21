package dominioTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import util.Fechautil;
import util.FestivosColombia;

public class FestivosTest {
	
	FestivosColombia festivos=new FestivosColombia();
	ArrayList<Calendar> listafestivos=FestivosColombia.diasFestivos(2019);
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
	@Test
	public void juevesSanto2016() {
		ArrayList<Calendar> listafestivos2016=FestivosColombia.diasFestivos(2016);
		fechaDePrueba.set(2016,Calendar.MARCH,24);
		assertTrue(festivos.esfestivo(listafestivos2016,fechaDePrueba));
	}
	@Test
	public void diaDeLaRaza2298() {
		ArrayList<Calendar> listafestivos2298=FestivosColombia.diasFestivos(2298);
		fechaDePrueba.set(2298,Calendar.OCTOBER,17);
		assertTrue(festivos.esfestivo(listafestivos2298,fechaDePrueba));
	}
	@Test
	public void noEsFestivoEn2298() {
		ArrayList<Calendar> listafestivos2298=FestivosColombia.diasFestivos(2298);
		fechaDePrueba.set(2298,Calendar.APRIL,18);
		assertFalse(festivos.esfestivo(listafestivos2298,fechaDePrueba));
	}
	@Test
	public void diaDeSanJose2150() {
		ArrayList<Calendar> listafestivos2150=FestivosColombia.diasFestivos(2150);
		fechaDePrueba.set(2150,Calendar.MARCH,23);
		assertTrue(festivos.esfestivo(listafestivos2150,fechaDePrueba));
	}
	@Test
	public void noEsFestivoEn2150() {
		ArrayList<Calendar> listafestivos2150=FestivosColombia.diasFestivos(2150);
		fechaDePrueba.set(2150,Calendar.SEPTEMBER,11);
		assertFalse(festivos.esfestivo(listafestivos2150,fechaDePrueba));
	}

}
