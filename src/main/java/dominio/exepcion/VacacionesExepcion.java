package dominio.exepcion;

public class VacacionesExepcion extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public VacacionesExepcion(String message) {
		super(message);
	}
	
}
