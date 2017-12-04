package dominio.constantes;

public enum EstadosSolicitud {

	PENDIENTE(1), APROBADA(2), RECHAZADA(3);
	private Integer value;
	
	EstadosSolicitud(Integer a){
		this.value = a;
	}
	
	public Integer getValue() {
		return value;
	}	
}
