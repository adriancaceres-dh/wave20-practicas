package com.bootcamp.appstarwars.repository;

import com.bootcamp.appstarwars.models.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    public List<Personaje> personajesHallados(String query);
}
