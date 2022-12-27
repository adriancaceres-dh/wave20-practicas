package com.example.personaje.service;

import com.example.personaje.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> findByName(String name);
}
