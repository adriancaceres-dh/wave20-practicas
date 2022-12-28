package com.bootcamp.StarWars.Service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.model.Personaje;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getPersonajes();
    public List<PersonajeDTO> getPersonajesByName(String name);
}
