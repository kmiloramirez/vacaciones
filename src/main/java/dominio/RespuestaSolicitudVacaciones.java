package dominio;

import java.util.Calendar;

public class RespuestaSolicitudVacaciones {

	private Calendar fechaDeinicioDeVacaciones;
	private Calendar fechaDeRegreso;
	private int cantidadDeDias;
	private int estado;
	
	public Calendar getFechaDeinicioDeVacaciones() {
		return fechaDeinicioDeVacaciones;
	}
	public Calendar getFechaDeRegreso() {
		return fechaDeRegreso;
	}
	public int getCantidadDeDias() {
		return cantidadDeDias;
	}
	public int getEstado() {
		return estado;
	}
	public RespuestaSolicitudVacaciones(Calendar fechaDeinicioDeVacaciones, Calendar FechaDeRegreso,
			int cantidadDeDias, int estado) {
		super();
		this.fechaDeinicioDeVacaciones = fechaDeinicioDeVacaciones;
		this.fechaDeRegreso = FechaDeRegreso;
		this.cantidadDeDias = cantidadDeDias;
		this.estado = estado;
	}
	
	
	
}

