package com.example.ejerciciodeportistas.controllers;

import com.example.ejerciciodeportistas.dtos.DeporteDTO;
import com.example.ejerciciodeportistas.dtos.PersonaDeporteDTO;
import com.example.ejerciciodeportistas.servicios.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador {

  private Services services = new Services();

  @GetMapping("/findSports")
  @ResponseBody
  public List<DeporteDTO> obtenerDeportes() {
    return services.obtenerDeportes();
  }

  @GetMapping("/findSport/{name}")
  @ResponseBody
  public ResponseEntity<DeporteDTO> buscarDeporte(@PathVariable(required = false) String name) {
    if (name == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(services.buscarDeporte(name), HttpStatus.OK);
  }

  @GetMapping("/findSportsPersons")
  @ResponseBody
  public List<PersonaDeporteDTO> buscarDeportePersona() {
    return services.obtenerPersonasDeportes();
  }
}


