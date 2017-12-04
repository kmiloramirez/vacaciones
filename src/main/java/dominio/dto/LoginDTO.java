package dominio.dto;

public class LoginDTO {
	public String usuario;
	public String contrasena;
	public LoginDTO(){
	
	}
	public LoginDTO(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public LoginDTO(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	
	
}
