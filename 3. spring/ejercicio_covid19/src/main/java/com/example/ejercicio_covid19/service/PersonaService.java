package com.example.ejercicio_covid19.service;

import com.example.ejercicio_covid19.dto.response.PersonaEnRiesgoResponseDto;
import com.example.ejercicio_covid19.model.Persona;
import com.example.ejercicio_covid19.repository.RepositoryPersona;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {

    ModelMapper modelMapper;
    private RepositoryPersona repositoryPersona;

    public PersonaService(){
        repositoryPersona = new RepositoryPersona();
        modelMapper = new ModelMapper();
    }

    public List<PersonaEnRiesgoResponseDto> personasEnRiesgo(){
        List<Persona> personasEnRiesgo = repositoryPersona.findAll().stream().
                filter(e -> !e.getSintomas().isEmpty() && e.getEdad() >= 60).collect(Collectors.toList());
        return personasEnRiesgo.stream().map(e -> modelMapper.map(e,PersonaEnRiesgoResponseDto.class)).collect(Collectors.toList());
    }
}
