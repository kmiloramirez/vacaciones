package com.ceiba.vacaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"dominio","servicio","com.ceiba.vacaciones","persistencia.repositorio","ldap"})
@EntityScan("persistencia.entidad")
public class VacacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacacionesApplication.class, args);
		
	}
}
