package com.bootcamp.star_wars.service;

import com.bootcamp.star_wars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonajesPorNombre(String nombre);
}
