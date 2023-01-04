package com.bootcamp.prueba.service;

import com.bootcamp.prueba.dto.PersonajeDto;
import com.bootcamp.prueba.repository.StarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService {
    private final StarWarsRepository starWarsRepository;

    public StarWarsService(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }


    public List<PersonajeDto> getAllByName(String name) {
        return starWarsRepository.getAll().stream()
                .filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList())
                .stream().map(personaje -> mapper.map(personaje, PersonajeDto))
                .collect(Collectors.toList());
    }
}
