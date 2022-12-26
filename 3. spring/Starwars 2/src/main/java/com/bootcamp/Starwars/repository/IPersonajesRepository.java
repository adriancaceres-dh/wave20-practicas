package com.bootcamp.Starwars.repository;

import com.bootcamp.Starwars.dto.PersonajeDTO;
import com.bootcamp.Starwars.model.Personaje;

import java.util.List;

public interface IPersonajesRepository {
    List<Personaje> buscarTodos();
}
