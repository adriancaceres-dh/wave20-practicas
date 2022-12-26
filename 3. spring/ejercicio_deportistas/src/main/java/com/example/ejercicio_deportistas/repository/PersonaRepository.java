package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    List<Persona> personas;

    DeporteRepository deporteRepository;

    public PersonaRepository(){
        deporteRepository = new DeporteRepository();
        personas = new ArrayList<>();
        personas.add(new Persona("Jesus","Dias",24));
        personas.add(new Persona("Nicolas","Ballesteros",23));
        personas.add(new Persona("Tomas","Gonzalez",22));

        personas.get(0).getDeportes().add(deporteRepository.findByName("Rugby"));
        personas.get(0).getDeportes().add(deporteRepository.findByName("Baloncesto"));
        personas.get(1).getDeportes().add(deporteRepository.findByName("Alpinismo"));
        personas.get(2).getDeportes().add(deporteRepository.findByName("Ajedrez"));

    }

    public void save(Persona persona){
        personas.add(persona);
    }

    public List<Persona> findAll(){
        return personas;
    }
}
