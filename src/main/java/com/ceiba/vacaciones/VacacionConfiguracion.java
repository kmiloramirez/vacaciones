package com.ceiba.vacaciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import dominio.AdministradorSolicitudes;
import dominio.CalculoDeDiasDeVacaciones;
import ldap.Ldapconexion;

@Configuration
public class VacacionConfiguracion {
	
	@Bean
	public CalculoDeDiasDeVacaciones creaCalculoDeDiasDeVacaciones(){
		return new CalculoDeDiasDeVacaciones();
	}
	
	@Bean
	public AdministradorSolicitudes creaAdministradorSolicitudes(){
		return new AdministradorSolicitudes();
	}
	
	@Bean
	public Ldapconexion crearConexionLDAP(){
		return new Ldapconexion();
	}

		
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
