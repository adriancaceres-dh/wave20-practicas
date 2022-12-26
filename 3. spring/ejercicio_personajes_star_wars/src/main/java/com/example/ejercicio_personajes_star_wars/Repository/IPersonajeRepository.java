package com.example.ejercicio_personajes_star_wars.Repository;

import com.example.ejercicio_personajes_star_wars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> findAll();

    public List<Personaje> findByName(String name);
}
