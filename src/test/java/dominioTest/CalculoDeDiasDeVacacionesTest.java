package dominioTest;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


import dominio.CalculoDeDiasDeVacaciones;
import dominio.SolicitudVacaciones;
import utilidadFecha.Fechautil;

public class CalculoDeDiasDeVacacionesTest {
	Calendar fechaInicioVacionesTest = Calendar.getInstance();
	Calendar fechaFinVacionesTest = Calendar.getInstance();
	Calendar fechaMaximaDeRegresoTest = Calendar.getInstance();
	SolicitudVacaciones testSolicitudVacaciones;
	CalculoDeDiasDeVacaciones calculoDeDiasDeVacaciones = new CalculoDeDiasDeVacaciones();

	@Test
	public void anioDEsolicitudTest() {
		fechaInicioVacionesTest.set(2018, 0, 1);
		fechaFinVacionesTest.set(2018, 0, 1);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		Assert.assertTrue(calculoDeDiasDeVacaciones.anioDeSolicitud(testSolicitudVacaciones) == 2018);
	}
	@Test
	public void noEeElAnioDEsolicitudTest() {
		fechaInicioVacionesTest.set(2017, 0, 1);
		fechaFinVacionesTest.set(2018, 0, 1);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		Assert.assertFalse(calculoDeDiasDeVacaciones.anioDeSolicitud(testSolicitudVacaciones)== 2018);

	}
	@Test
	public void obtenerFestivosDelAnioDesolicitudTest() {
		fechaInicioVacionesTest.set(2017, 0, 1);
		fechaFinVacionesTest.set(2018, 0, 1);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		calculoDeDiasDeVacaciones.obtenerFestivosDelAnioDesolicitud(testSolicitudVacaciones);
		Assert.assertFalse(calculoDeDiasDeVacaciones.diasFestivosDeUnAnio.isEmpty());
	}
	
	@Test
	public void esUnDiaEntreLunesYViernesTest(){
		fechaMaximaDeRegresoTest.set(2017, 10, 20);
		Assert.assertTrue(calculoDeDiasDeVacaciones.esUnDiaEntreLunesYViernes(fechaMaximaDeRegresoTest));
	}
	@Test
	public void noEsUnDiaEntreLunesYViernesTest(){
		fechaMaximaDeRegresoTest.set(2017, 10, 26);
		Assert.assertFalse(calculoDeDiasDeVacaciones.esUnDiaEntreLunesYViernes(fechaMaximaDeRegresoTest));
	}
	@Test
	public void contarDiasHabilesTest(){
		fechaInicioVacionesTest.set(2019, Calendar.OCTOBER, 7);
		System.out.println("fechaInicioVacionesTest: "+fechaInicioVacionesTest.getTime());
		fechaFinVacionesTest.set(2019, Calendar.OCTOBER, 28);
		System.out.println("fechaFinVacionesTest: "+ fechaFinVacionesTest.getTime());
		Calendar fechaEsperadaFinVaciones = Calendar.getInstance();
		fechaEsperadaFinVaciones.set(2019, Calendar.OCTOBER, 29);
		Fechautil.asignarTiempoCero(fechaEsperadaFinVaciones);
		System.out.println("fechaEsperadaFinVaciones: "+ fechaEsperadaFinVaciones.getTime());
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		calculoDeDiasDeVacaciones.CalcularDias(testSolicitudVacaciones);
		System.out.println("dias:" +testSolicitudVacaciones.getCantidadDeDias());
		System.out.println("fecha de regreso: "+testSolicitudVacaciones.getFechaDeRegreso().getTime());
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==15&&testSolicitudVacaciones.getFechaDeRegreso().equals(fechaEsperadaFinVaciones));
	}
}
