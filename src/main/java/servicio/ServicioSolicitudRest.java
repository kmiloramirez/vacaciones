package servicio;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.AdministradorSolicitudes;
import dominio.SolicitudVacaciones;

@EnableAutoConfiguration
@Transactional
@RestController
public class ServicioSolicitudRest {

	@RequestMapping("/home")
	@ResponseBody
	String home() {
		return "Modulo_Vacaciones";
	}
	
	@RequestMapping(value = "/solicitud/vacaciones", method = RequestMethod.POST)
	@ResponseBody
	public SolicitudVacaciones IngresarsolicitudVacaciones(@RequestBody SolicitudVacaciones solicitud) {
		SolicitudVacaciones solicitudVacaciones=solicitud;
		return AdministradorSolicitudes.ingresar(solicitudVacaciones);					
	}
	
}
