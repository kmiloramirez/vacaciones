package dominio;

import java.util.Calendar;

public class SolicitudVacaciones {

	private Calendar fechaDeSolicitudDeinicio;
	private Calendar fechaDeSolicitudFin;
	private Calendar fechaDeRegreso;
	private int CantidadDeDias;
	private String jefeInmediato;

	public Calendar getFechaDeSolicitudDeinicio() {
		return fechaDeSolicitudDeinicio;
	}

	public Calendar getFechaDeSolicitudFin() {
		return fechaDeSolicitudFin;
	}

	public Calendar getFechaDeRegreso() {
		return fechaDeRegreso;
	}

	public int getCantidadDeDias() {
		return CantidadDeDias;
	}

	public String getJefeInmediato() {
		return jefeInmediato;
	}

	public SolicitudVacaciones(Calendar fechaDeSolicitudDeinicio, Calendar fechaDeSolicitudFin, String jefeInmediato) {
		this.fechaDeSolicitudDeinicio = fechaDeSolicitudDeinicio;
		this.fechaDeSolicitudFin = fechaDeSolicitudFin;
		this.jefeInmediato = jefeInmediato;
	}

	public void setFechaDeRegreso(Calendar fechaDeRegreso) {
		this.fechaDeRegreso = fechaDeRegreso;
	}

	public void setCantidadDeDias(int cantidadDeDias) {
		CantidadDeDias = cantidadDeDias;
	}

	public SolicitudVacaciones(int cantidadDeDias) {
		CantidadDeDias = cantidadDeDias;
	}

}
