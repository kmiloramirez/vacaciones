package servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.AdministradorSolicitudes;
import dominio.RespuestaSolicitudVacaciones;
import dominio.SolicitudVacaciones;
import dominio.dto.LoginDTO;
import dominio.dto.SolicitudVacacionesDTO;

@EnableAutoConfiguration
@Transactional
@RestController
public class ServicioSolicitudRest {
	@Autowired
	AdministradorSolicitudes administrador;

	@CrossOrigin
	@RequestMapping("/home")
	@ResponseBody
	String home() {
		return "Modulo_Vacaciones";
	}

	@CrossOrigin
	@RequestMapping(value = "/solicitud/vacaciones", method = RequestMethod.POST)
	@ResponseBody
	public RespuestaSolicitudVacaciones ingresarSolicitudVacaciones(@RequestBody SolicitudVacacionesDTO solicitudDto) {
		return administrador.ingresar(solicitudDto);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/revisar/solicitud/vacaciones", method = RequestMethod.GET)
	@ResponseBody
	public List<SolicitudVacaciones> revisarSolicitudesDeVacaciones(@RequestParam String jefeInmediato) {
		return administrador.consultarSolicitudesPendientes(jefeInmediato);
	}
	@CrossOrigin
	@RequestMapping(value ="/login", method= RequestMethod.POST)
	@ResponseBody
	    public LoginDTO login (@RequestBody LoginDTO loginDTO) {
	     return administrador.login(loginDTO);
	    }

	
}
