package persistencia.entidad;

import java.util.Calendar;

import javax.persistence.*;

import org.hibernate.annotations.NamedQuery;

@Entity(name = "Solicitud")
@NamedQuery(name = "Solicitud.BuscarSolicitudesPendientes", query = "SELECT solicitud from Solicitud solicitud where solicitud.estado = 0 AND solicitud.jefeInmediato = :jefeInmediato")

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
	private int cantidadDeDias;
	@Column
	private String jefeInmediato;
	@Column
	private int estado;

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

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
		return cantidadDeDias;
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

	public void setCantidadDeDias(int cantidaddeDias) {
		cantidadDeDias = cantidaddeDias;
	}

	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}

}
