package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.response.DeportistasResponseDto;
import com.bootcamp.deportistas.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {

    private PersonaRepository personaRepository;
    public PersonaService() {
        personaRepository = new PersonaRepository();
    }

    public List<DeportistasResponseDto> getDeportistas() {
        List<DeportistasResponseDto> deportistas = personaRepository.deportistas().stream()
                .map( p -> new DeportistasResponseDto(p.getNombre(),p.getApellido(),p.getDeporte().getNombre()))
                .collect(Collectors.toList());
        return deportistas;
    }
}
