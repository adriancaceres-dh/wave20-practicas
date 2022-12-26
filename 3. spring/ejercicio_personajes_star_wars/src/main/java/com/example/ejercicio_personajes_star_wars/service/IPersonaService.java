package com.example.ejercicio_personajes_star_wars.service;

import com.example.ejercicio_personajes_star_wars.dto.response.PersonajeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {

    public List<PersonajeResponseDto> findByName(String name);

}
