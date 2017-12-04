package dominio.dto;

import java.util.Calendar;
import java.util.Date;

public class SolicitudVacacionesDTO {
	 public Calendar fechaInicial;
	 public Calendar fechaFinal;
	 public String jefeInmediato;
	 public Date fechaInicio;
	 public Date fechaFin;
	
	public Calendar getFechaInicial() {
		return fechaInicial;
	}
	public Calendar getFechaFinal() {
		return fechaFinal;
	}
	public String getJefeInmediato() {
		return jefeInmediato;
	}
	public void setFechaInicial(Calendar fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public void setFechaFinal(Calendar fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	
}
