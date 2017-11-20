package dominioTest;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


import dominio.CalculoDeDiasDeVacaciones;
import dominio.SolicitudVacaciones;

public class CalculoDeDiasDeVacacionesTest {
	Calendar fechaInicioVacionesTest = Calendar.getInstance();
	Calendar fechaFinVacionesTest = Calendar.getInstance();
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
	
	
}
