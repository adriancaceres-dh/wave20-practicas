package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.service.IServicePersonajes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerPersonajes {

  private final IServicePersonajes servicePersonajes;

  public ControllerPersonajes(IServicePersonajes servicePersonajes) {
    this.servicePersonajes = servicePersonajes;
  }

  @GetMapping("/personajes/{name}")
  public ResponseEntity<List<PersonajeDto>> getPersonaje(@PathVariable String name) {
    return new ResponseEntity<>(servicePersonajes.buscarPersonaje(name), HttpStatus.OK);
  }

}
