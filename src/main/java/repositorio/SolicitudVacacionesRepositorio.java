package repositorio;

import java.util.List;

import dominio.SolicitudVacaciones;

public interface SolicitudVacacionesRepositorio {

	void insertar(SolicitudVacaciones solicitud);
	List<SolicitudVacaciones> obtenerListaSolicitudVacaciones (String jefeInmediato);
}
