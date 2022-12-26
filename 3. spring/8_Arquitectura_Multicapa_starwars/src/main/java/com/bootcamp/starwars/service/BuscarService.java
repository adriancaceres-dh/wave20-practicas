package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.PersonajeResponseDto;
import com.bootcamp.starwars.repositories.IPersonajeRepository;
import com.bootcamp.starwars.repositories.PersonajeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarService {

    @Autowired
    private PersonajeRepositoryImpl personajeRepository;

    public List<PersonajeResponseDto> find(String query) {
        return personajeRepository.findAllByNameContainsDto(query);
    }
}
