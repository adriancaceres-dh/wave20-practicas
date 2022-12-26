package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDto;

import java.util.List;

public interface PersonajeService {
    List<PersonajeDto> getAll();
    List<PersonajeDto> getByName(String name);
}
