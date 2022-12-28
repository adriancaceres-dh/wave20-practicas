package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDto;

import java.util.List;

public interface IServicePersonajes {
  List<PersonajeDto> buscarPersonaje(String name);
}
