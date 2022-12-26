package com.example.starwars.repository;

import com.example.starwars.model.Personaje;

import java.util.List;

public interface PersonajeRepository {
    List<Personaje> getPersonajes();
    List<Personaje> getPersonajesByName(String name);
}
