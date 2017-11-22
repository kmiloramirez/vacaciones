package servicio;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.AdministradorSolicitudes;
import dominio.SolicitudVacaciones;
import dominio.SolicitudVacacionesDTO;
import util.Fechautil;

@EnableAutoConfiguration
@Transactional
@RestController
public class ServicioSolicitudRest {
	
	@CrossOrigin	
	@RequestMapping("/home")
	@ResponseBody
	String home() {
		return "Modulo_Vacaciones";
	}
	@CrossOrigin
	@RequestMapping(value = "/solicitud/vacaciones", method = RequestMethod.POST)
	@ResponseBody	
	public SolicitudVacaciones ingresarSolicitudVacaciones(@RequestBody SolicitudVacacionesDTO solicitudDto) {
			
			solicitudDto.setFechaInicial(Fechautil.dateToCalendarColombianZone(solicitudDto.getFechaInicio()));
			solicitudDto.setFechaFinal(Fechautil.dateToCalendarColombianZone(solicitudDto.getFechaFin()));
			AdministradorSolicitudes administrador= new AdministradorSolicitudes();
			System.out.println(solicitudDto.getFechaInicial().getTime());
			System.out.println(solicitudDto.getFechaFinal().getTime());
			return administrador.ingresar(solicitudDto.getFechaInicial(),solicitudDto.getFechaFinal(),solicitudDto.getJefeInmediato());
	}
	
}
