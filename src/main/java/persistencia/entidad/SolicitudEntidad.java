package persistencia.entidad;

import java.util.Calendar;

import javax.persistence.*;

@Entity(name = "solisitud")


public class SolicitudEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Calendar fechaDeSolicitudDeinicio;
	@Column
	private Calendar fechaDeSolicitudFin;
	@Column
	private Calendar fechaDeRegreso;
	@Column
	private int CantidadDeDias;
	@Column
	private String jefeInmediato;
	public Long getId() {
		return id;
	}
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setFechaDeSolicitudDeinicio(Calendar fechaDeSolicitudDeinicio) {
		this.fechaDeSolicitudDeinicio = fechaDeSolicitudDeinicio;
	}
	public void setFechaDeSolicitudFin(Calendar fechaDeSolicitudFin) {
		this.fechaDeSolicitudFin = fechaDeSolicitudFin;
	}
	public void setFechaDeRegreso(Calendar fechaDeRegreso) {
		this.fechaDeRegreso = fechaDeRegreso;
	}
	public void setCantidadDeDias(int cantidadDeDias) {
		CantidadDeDias = cantidadDeDias;
	}
	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}
	
	
	
}
