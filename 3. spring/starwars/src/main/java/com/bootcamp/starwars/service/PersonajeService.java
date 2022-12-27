package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.model.Personaje;
import com.bootcamp.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
        @Autowired
        private PersonajeRepository personajeRepository;
        private PersonajeDTO personajeDTO;

        public List<PersonajeDTO> buscarPersonaje(String nombre) {

               return personajeRepository.todosLosPersonajes()
                        .stream()
                        .filter(personaje -> personaje.getName().toUpperCase().contains(nombre.toUpperCase()))
                        .map(personaje -> new PersonajeDTO (personaje))
                        .collect(Collectors.toList());

        }


}
