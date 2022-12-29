package com.spring.Deportistas;

import com.spring.Deportistas.model.Deporte;
import com.spring.Deportistas.model.Persona;
import com.spring.Deportistas.repository.DeporteRepository;
import com.spring.Deportistas.repository.PersonasRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DeportistasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeportistasApplication.class, args);

		List<Deporte> listaDeportesPersona1 = new ArrayList<>();
		listaDeportesPersona1.add(new Deporte("Futbol", 1));
		listaDeportesPersona1.add(new Deporte("Tenis", 1));
		List<Deporte> listaDeportesPersona2 = new ArrayList<>();
		listaDeportesPersona2.add(new Deporte("Futbol", 1));


		PersonasRepository.personas.add(new Persona("Persona", "1", 12, listaDeportesPersona1));
		PersonasRepository.personas.add(new Persona("Persona", "2", 5,
				listaDeportesPersona2));
		// no hace deporte
		PersonasRepository.personas.add(new Persona("Carlos", "Ros", 1,
				null));

		DeporteRepository.deportes.add(new Deporte("Futbol",1));
		DeporteRepository.deportes.add(new Deporte("Tenis",1));
	}

}
