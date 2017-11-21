package testdatabuilder;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import dominio.CalculoDeDiasDeVacaciones;
import dominio.SolicitudVacaciones;
import persistencia.builder.SolicitudBuilder;
import persistencia.entidad.SolicitudEntidad;

public class SolicitudVacacionesTestDatabBuilder {

	Calendar fechaInicioVacionesTest = Calendar.getInstance();
	Calendar fechaFinVacionesTest = Calendar.getInstance();
	SolicitudVacaciones testSolicitudVacaciones;
	CalculoDeDiasDeVacaciones calculoDeDiasDeVacaciones = new CalculoDeDiasDeVacaciones();
	
	@Test
	public void deDominioAEntidadTest(){
		fechaInicioVacionesTest.set(2017, Calendar.FEBRUARY, 6);
		fechaFinVacionesTest.set(2017, Calendar.FEBRUARY, 28);
		testSolicitudVacaciones = new SolicitudVacaciones(fechaInicioVacionesTest, fechaFinVacionesTest, "David");
		calculoDeDiasDeVacaciones.calcularDias(testSolicitudVacaciones);
		Assert.assertNotNull(SolicitudBuilder.convertirAEntity(testSolicitudVacaciones));
	}
	
	@Test
	public void deEntidadADominioTest(){
		SolicitudEntidad solicitudEntidad = new SolicitudEntidad();
		solicitudEntidad.setCantidadDeDias(1);
		solicitudEntidad.setFechaDeRegreso(fechaFinVacionesTest);
		solicitudEntidad.setFechaDeSolicitudDeinicio(fechaInicioVacionesTest);
		solicitudEntidad.setFechaDeSolicitudFin(fechaFinVacionesTest);
		solicitudEntidad.setJefeInmediato("David");
		
		Assert.assertNotNull(SolicitudBuilder.convertirADominio(solicitudEntidad));
	}
	
	@Test
	public void deEntidadADominioEnDias(){
		SolicitudEntidad solicitudEntidad = new SolicitudEntidad();
		solicitudEntidad.setFechaDeSolicitudDeinicio(null);
		Assert.assertNotNull(SolicitudBuilder.convertirADominio(solicitudEntidad));
	}
	@Test
	public void deEntidadADominioNull(){
		SolicitudEntidad solicitudEntidad =null;
		Assert.assertNull(SolicitudBuilder.convertirADominio(solicitudEntidad));
	}
}
