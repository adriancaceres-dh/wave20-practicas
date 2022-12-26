package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    public Personaje getPersonaje();
    public List<Personaje> getPersonajesByName (String name);
    public List<Personaje> loadDatabase();

}
