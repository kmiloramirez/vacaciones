package dominio.excepcion;

public class SolicitudVacacionesExcepcion extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public SolicitudVacacionesExcepcion(String message) {
		super(message);
	}
}
