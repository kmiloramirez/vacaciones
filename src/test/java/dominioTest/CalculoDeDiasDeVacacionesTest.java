package dominioTest;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


import dominio.CalculoDeDiasDeVacaciones;
import dominio.SolicitudVacaciones;
import dominio.constantes.EstadosSolicitud;
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
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		Assert.assertTrue(CalculoDeDiasDeVacaciones.anioDeSolicitud(testSolicitudVacaciones) == 2018);
	}
	@Test
	public void noEeElAnioDEsolicitudTest() {
		fechaInicioVacionesTest.set(2017, 0, 1);
		fechaFinVacionesTest.set(2018, 0, 1);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		Assert.assertFalse(CalculoDeDiasDeVacaciones.anioDeSolicitud(testSolicitudVacaciones)== 2018);

	}
	@Test
	public void obtenerFestivosDelAnioDesolicitudTest() {
		fechaInicioVacionesTest.set(2017, 0, 1);
		fechaFinVacionesTest.set(2018, 0, 1);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		CalculoDeDiasDeVacaciones.obtenerFestivosDelAnioDesolicitud(testSolicitudVacaciones);
		Assert.assertFalse(CalculoDeDiasDeVacaciones.getDiasFestivosDeUnAnio().isEmpty());
	}
	

	@Test
	public void contarDiasHabilesTest(){
		fechaInicioVacionesTest.set(2017, Calendar.FEBRUARY, 6);
		fechaFinVacionesTest.set(2017, Calendar.FEBRUARY, 24);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.FEBRUARY, 27);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==15&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestConFechaDeRegresoMayor15Dias(){
		fechaInicioVacionesTest.set(2017, Calendar.FEBRUARY, 6);
		fechaFinVacionesTest.set(2017, Calendar.FEBRUARY, 28);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.FEBRUARY, 27);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==15&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestConFechaDeRegresoMenor15Dias(){
		fechaInicioVacionesTest.set(2017, Calendar.FEBRUARY, 8);
		fechaFinVacionesTest.set(2017, Calendar.FEBRUARY, 14);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.FEBRUARY, 15);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==5&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestConFechaFestivaPorMedio(){
		fechaInicioVacionesTest.set(2017, Calendar.NOVEMBER, 3);
		fechaFinVacionesTest.set(2017, Calendar.NOVEMBER, 14);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.NOVEMBER, 15);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==6&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestConFechaFinalSabado(){
		fechaInicioVacionesTest.set(2017, Calendar.NOVEMBER, 4);
		fechaFinVacionesTest.set(2017, Calendar.NOVEMBER, 11);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.NOVEMBER, 14);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias() == 4
				&& testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestConFechaFinalDomingo(){
		fechaInicioVacionesTest.set(2017, Calendar.NOVEMBER, 4);
		fechaFinVacionesTest.set(2017, Calendar.NOVEMBER, 12);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.NOVEMBER, 14);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==4&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestConFechaFinalViernes(){
		fechaInicioVacionesTest.set(2017, Calendar.NOVEMBER, 2);
		fechaFinVacionesTest.set(2017, Calendar.NOVEMBER, 3);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.NOVEMBER, 7);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==2&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
	@Test
	public void contarDiasHabilesTestParaEntrarUnDIaFestivo(){
		fechaInicioVacionesTest.set(2017, Calendar.NOVEMBER, 2);
		fechaFinVacionesTest.set(2017, Calendar.NOVEMBER, 6);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.NOVEMBER, 7);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==2&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
		
	@Test
	public void contarDiasHabilesTestParaEntrarPAsadoUnFestivo(){
		fechaInicioVacionesTest.set(2017, Calendar.NOVEMBER, 1);
		fechaFinVacionesTest.set(2017, Calendar.NOVEMBER, 8);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2017, Calendar.NOVEMBER, 9);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==5&&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
		
	@Test
	public void vacacioneConCambioDeAnio(){
		fechaInicioVacionesTest.set(2017, Calendar.DECEMBER, 27);
		fechaFinVacionesTest.set(2018, Calendar.JANUARY, 4);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David",EstadosSolicitud.PENDIENTE.getValue());
 		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Calendar fechaEsperadaTest=Calendar.getInstance();
		fechaEsperadaTest.set(2018, Calendar.JANUARY, 5);
		Fechautil.asignarTiempoCero(fechaEsperadaTest);
		Assert.assertTrue(testSolicitudVacaciones.getCantidadDeDias()==6 &&testSolicitudVacaciones.getFechaDeRegreso().getTime().equals(fechaEsperadaTest.getTime()));
	}
}
