package com.example.starwars.service;

import com.example.starwars.dao.IRepositorioPersonajes;
import com.example.starwars.dao.RepositorioPersonajesJson;
import com.example.starwars.dto.PersonajeDto;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicePersonajes {
  ModelMapper modelMapper = new ModelMapper();
  private IRepositorioPersonajes repositorioPersonajes;

  public ServicePersonajes(IRepositorioPersonajes repositorioPersonajes) {
    this.repositorioPersonajes = repositorioPersonajes;
  }

  public List<PersonajeDto> buscarPersonaje(String name) {

    return repositorioPersonajes.buscarPersonaje(name).stream()
            .map(personaje -> modelMapper.map(personaje, PersonajeDto.class))
            .collect(Collectors.toList());
  }
}
