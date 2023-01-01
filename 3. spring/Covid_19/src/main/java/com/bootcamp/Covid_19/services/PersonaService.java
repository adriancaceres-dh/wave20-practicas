package com.bootcamp.Covid_19.services;

import com.bootcamp.Covid_19.dto.PersonaEnRiesgoDTO;
import com.bootcamp.Covid_19.models.Persona;
import com.bootcamp.Covid_19.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> getAll(){
       return  personaRepository.getListaPersonas();
    }

    public List<PersonaEnRiesgoDTO> getPersonasEnRiesgo() {
        List<PersonaEnRiesgoDTO> personasEnRiesgoDTO= personaRepository.getListaPersonas().stream()
                .filter(persona -> persona.getEdad()>60 && !persona.getSintomas().isEmpty()).collect(Collectors.toList())
                .stream().map(persona -> modelMapper.map(persona, PersonaEnRiesgoDTO.class)).collect(Collectors.toList());
        return personasEnRiesgoDTO;
    }
}
