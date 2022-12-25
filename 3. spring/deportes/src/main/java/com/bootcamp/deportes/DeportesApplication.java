package com.bootcamp.deportes;

import com.bootcamp.deportes.model.Deporte;
import com.bootcamp.deportes.model.Persona;
import com.bootcamp.deportes.service.DeporteService;
import com.bootcamp.deportes.service.PersonaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DeportesApplication {

	static Deporte d1 = new Deporte("Futbol", 2);
	static Deporte d2 = new Deporte("Ajedrez", 1);
	static Deporte d3 = new Deporte("Voley", 4);
	static List<Deporte> deportes = new ArrayList<>(Arrays.asList(d1, d2, d3));
	public static DeporteService dService = new DeporteService(deportes);

	static Persona p1 = new Persona("Laura", "Lapka", 26, d1);
	static Persona p2 = new Persona("Marcos", "Proa", 16, d2);
	static Persona p3 = new Persona("Valentina", "Silanova", 66, d3);
	static List<Persona> personas = new ArrayList<>(Arrays.asList(p1, p2, p3));
	public static PersonaService pService = new PersonaService(personas);

	public static void main(String[] args) {
		SpringApplication.run(DeportesApplication.class, args);
	}

}
