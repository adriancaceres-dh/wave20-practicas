package com.bootcamp.Starwars.service;

import com.bootcamp.Starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> buscarTodosPorNombre(String nombre);
}
