package com.wave20.ejercicio_starWars.service;


import com.wave20.ejercicio_starWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonajesPorNombre(String nombre);
}


