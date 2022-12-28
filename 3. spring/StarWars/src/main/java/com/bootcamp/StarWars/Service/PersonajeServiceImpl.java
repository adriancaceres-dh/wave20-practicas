package com.bootcamp.StarWars.Service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService{
    @Autowired
    private PersonajeRepository personajeRepository;
    @Override
    public List<PersonajeDTO> getPersonajes() {
        return personajeRepository.getPersonajes().stream()
                .map(personaje -> new PersonajeDTO(personaje.getName(),personaje.getGender(),personaje.getHomeworld(),personaje.getSpecies(),personaje.getHeight(),personaje.getMass()))
                .collect(Collectors.toList());
    }
    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) {
        return personajeRepository.getPersonajeByName(name).stream()
                .map(personaje -> new PersonajeDTO(personaje.getName(),personaje.getGender(),personaje.getHomeworld(),personaje.getSpecies(),personaje.getHeight(),personaje.getMass()))
                .collect(Collectors.toList());
    }
}
