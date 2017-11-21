package dominioTest;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


import dominio.CalculoDeDiasDeVacaciones;
import dominio.SolicitudVacaciones;
import util.Fechautil;

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
		fechaFinVacionesTest.set(2019, Calendar.OCTOBER, 31);	
		Calendar fechaEsperadaFinVaciones = Calendar.getInstance();
		fechaEsperadaFinVaciones.set(2019, Calendar.OCTOBER, 29);	
		Fechautil.asignarTiempoCero(fechaEsperadaFinVaciones);
		Fechautil.asignarTiempoCero(fechaEsperadaFinVaciones);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==15&&testSolicitudVacaciones.getFechaDeRegreso().equals(fechaEsperadaFinVaciones));
	}
	@Test
	public void contarDiasHabilesTestParaEntrarUnDIaFestivo(){
		System.out.println(fechaInicioVacionesTest.getTime());
		fechaInicioVacionesTest.set(2019, Calendar.OCTOBER, 7);
		System.out.println(fechaInicioVacionesTest.getTime());
		System.out.println(fechaFinVacionesTest.getTime());
		fechaFinVacionesTest.set(2019, Calendar.OCTOBER, 11);
		System.out.println(fechaFinVacionesTest.getTime());
		Calendar fechaEsperadaFinVaciones = Calendar.getInstance();
		fechaEsperadaFinVaciones.set(2019, Calendar.OCTOBER, 15);
		System.out.println(fechaEsperadaFinVaciones.getTime());
		Fechautil.asignarTiempoCero(fechaEsperadaFinVaciones);
		System.out.println(fechaEsperadaFinVaciones.getTime());
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		System.out.println("OBJETOSOLICITUD-->"+testSolicitudVacaciones.getFechaDeRegreso().getTime());
		System.out.println("ESPERADA-->"+fechaEsperadaFinVaciones.getTime());
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==4&&testSolicitudVacaciones.getFechaDeRegreso().equals(fechaEsperadaFinVaciones));
	}
	@Test
	public void contarDiasHabilesTestFinUnViernes(){
		fechaInicioVacionesTest.set(2019, Calendar.FEBRUARY, 4);
		Calendar fechaEsperadaFinVaciones = Calendar.getInstance();
		fechaEsperadaFinVaciones.set(2019, Calendar.FEBRUARY, 25);
		Fechautil.asignarTiempoCero(fechaEsperadaFinVaciones);
		Fechautil.asignarTiempoCero(fechaInicioVacionesTest);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==15&&testSolicitudVacaciones.getFechaDeRegreso().equals(fechaEsperadaFinVaciones));
	}
	
}
