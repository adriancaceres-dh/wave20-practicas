package com.example.starwars.service;

import com.example.starwars.dao.IRepositorioPersonajes;
import com.example.starwars.dto.PersonajeDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePersonajes implements IServicePersonajes {
  private final ModelMapper modelMapper = new ModelMapper();
  private final IRepositorioPersonajes repositorioPersonajes;

  public ServicePersonajes(IRepositorioPersonajes repositorioPersonajes) {
    this.repositorioPersonajes = repositorioPersonajes;
  }

  public List<PersonajeDto> buscarPersonaje(String name) {

    return repositorioPersonajes.buscarPersonaje(name).stream()
            .map(personaje -> modelMapper.map(personaje, PersonajeDto.class))
            .collect(Collectors.toList());
  }
}
