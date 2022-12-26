package com.example.ejercicio_personajes_star_wars.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {

    public List<PersonaService> findAll();

}
