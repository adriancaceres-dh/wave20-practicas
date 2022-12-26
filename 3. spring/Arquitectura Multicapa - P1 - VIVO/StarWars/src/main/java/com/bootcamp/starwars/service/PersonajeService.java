package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.PersonajeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.starwars.repository.PersonajeRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonajeService implements IPersonajeService {


    @Autowired
    PersonajeRepository personajeRepository;
    ModelMapper mapper = new ModelMapper();

    public List<PersonajeDTO> buscarTodos() {
        return personajeRepository.buscarTodos().stream()
                .map(c -> mapper.map(c, PersonajeDTO.class)).collect(Collectors.toList());
    }

    public List<PersonajeDTO> buscarPersonajePorNombre(String nombre) {
        return personajeRepository.buscarPersonajePorNombre(nombre).stream()
                .map(c -> mapper.map(c, PersonajeDTO.class)).collect(Collectors.toList());
    }
}
