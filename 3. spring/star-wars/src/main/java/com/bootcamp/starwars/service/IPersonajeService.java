package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeService {

    public Personaje getPersonaje();
    public List<PersonajeDTO> getPersonajesByName (String name);

}
