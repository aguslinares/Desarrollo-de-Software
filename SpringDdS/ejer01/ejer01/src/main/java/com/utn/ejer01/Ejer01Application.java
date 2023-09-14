package com.utn.ejer01;

import com.utn.ejer01.entidades.Persona;
import com.utn.ejer01.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //lee los componentes propios de spring, más los que nosotros creamos
public class Ejer01Application {

	@Autowired //asociación con la clase PersonaRepository, inyecta la dependencia
	PersonaRepository personaRepository;

	public static void main(String[] args) {

		SpringApplication.run(Ejer01Application.class, args);
		System.out.println("Estoy funcionando hoy");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo) {
		return args -> {
			System.out.println("-------ESTOY FUNCIONANDO-------");

			Persona persona = new Persona();

			persona.setNombre("Juan");
			persona.setApellido("Pérez");
			persona.setEdad(30);

			personaRepository.save(persona); //guardo el objeto persona que cree arriba en la base de datos (insert bla bla bla into Persona)

			Persona personaRecuperada = personaRepository.findById(persona.getId());
				if (personaRecuperada != null) {

					System.out.println("Nombre: "+personaRecuperada.getNombre());
					System.out.println("Apellido: "+personaRecuperada.getApellido());
					System.out.println("Edad: "+personaRecuperada.getEdad());
					System.out.println("Calle: "+personaRecuperada.getDomicilio().getCalle());
					System.out.println("Número: "+personaRecuperada.getDomicilio().getNumero());
				};
			Persona persona1 = Persona.builder()
					.nombre("Juan")
					.apellido


		};

	}

}
