package com.bootcamp.PersonajesStarWars.Services;

import com.bootcamp.PersonajesStarWars.DTO.PersonajesDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajesDto> PersonajeEncontrarSegunNombre(String nombreEncontrar);
}
