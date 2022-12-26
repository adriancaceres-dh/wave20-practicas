package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDto;
import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;

    public List<PersonajeDto> listPersonajes() {
        return personajeRepository.getAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<PersonajeDto> findByName(String name) {
        return personajeRepository
                .findAll(personaje -> personaje.getName().contains(name))
                .stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private PersonajeDto convertToDto(Personaje personaje) {
        return new PersonajeDto(personaje);
    }
}
