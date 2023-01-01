package com.bootcamp.StarWars.services;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.repositories.PersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    PersonajeRepository personajeRepository;

    public List<PersonajeDTO> getCharacter(String name){
        return personajeRepository.getListaPersonajes().stream().filter(personaje -> personaje.getName().contains(name))
                .map(personaje -> modelMapper.map(personaje, PersonajeDTO.class)).collect(Collectors.toList());
    };


}
