package dominio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.constantes.EstadosSolicitud;
import dominio.dto.LoginDTO;
import dominio.dto.SolicitudVacacionesDTO;
import ldap.Ldapconexion;
import repositorio.SolicitudVacacionesRepositorio;
import util.Fechautil;

public class AdministradorSolicitudes {

	@Autowired
	CalculoDeDiasDeVacaciones calculoDeDiasDeVacaciones;
	@Autowired
	SolicitudVacacionesRepositorio solicitudVacacionesRepositorio;
	@Autowired
	Ldapconexion ldapconexion;
	
	public RespuestaSolicitudVacaciones ingresar(SolicitudVacacionesDTO solicitudVacacionesDTO) {
		SolicitudVacaciones solicitud = crearSolicitudDominio(solicitudVacacionesDTO);
		Fechautil.asignarTiempoCero(solicitud.getFechaDeSolicitudDeinicio());
		Fechautil.asignarTiempoCero(solicitud.getFechaDeSolicitudFin());
		calculoDeDiasDeVacaciones.calcularDias(solicitud);
		guardarSolicitud(solicitud);
		return new RespuestaSolicitudVacaciones(solicitud.getFechaDeSolicitudDeinicio(), solicitud.getFechaDeRegreso(),
				solicitud.getCantidadDeDias(), EstadosSolicitud.PENDIENTE.getValue());
	}

	@Transactional
	public void guardarSolicitud(SolicitudVacaciones solicitud) {
		solicitudVacacionesRepositorio.insertar(solicitud);
	}

	public SolicitudVacaciones crearSolicitudDominio(SolicitudVacacionesDTO solicitudVacacionesDTO) {
		solicitudVacacionesDTO
				.setFechaInicial(Fechautil.dateToCalendarColombianZone(solicitudVacacionesDTO.getFechaInicio()));
		solicitudVacacionesDTO
				.setFechaFinal(Fechautil.dateToCalendarColombianZone(solicitudVacacionesDTO.getFechaFin()));
		return new SolicitudVacaciones(solicitudVacacionesDTO.fechaInicial, solicitudVacacionesDTO.fechaFinal,
				solicitudVacacionesDTO.jefeInmediato, EstadosSolicitud.PENDIENTE.getValue());

	}
	
	@Transactional
	public List<SolicitudVacaciones> consultarSolicitudesPendientes(String jefeInmediato){
		return solicitudVacacionesRepositorio.obtenerListaSolicitudVacaciones(jefeInmediato);
	}
	
	@Transactional
	public LoginDTO login(LoginDTO loginDTO){
		String usuario= loginDTO.usuario;
		String contrasena= loginDTO.contrasena;
		return new LoginDTO(ldapconexion.autenticacion(usuario, contrasena));
		
	}
	

}
