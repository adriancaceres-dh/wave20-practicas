package com.example.ejerciciocalorias.controller;

import com.example.ejerciciocalorias.dao.PlatosRepo;
import com.example.ejerciciocalorias.dto.IngredienteDto;
import com.example.ejerciciocalorias.dto.PlatoDto;
import com.example.ejerciciocalorias.dto.RequestDto;
import com.example.ejerciciocalorias.service.CaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCalorias {
  @Autowired
  private CaloriasService caloriasService;
  @Autowired
  private PlatosRepo platosRepo;

  @GetMapping("/calorias/{nombre}/{peso}")
  public int getCaloriasPlato(@PathVariable String nombre, @PathVariable int peso) {
    PlatoDto platoDto = platosRepo.getPlato(nombre);
    return caloriasService.getCaloriasPlato(platoDto);
  }

  @GetMapping("/ingredientes/{nombre}")
  public IngredienteDto getIngredienteMasCalorico(@PathVariable String nombre) {
    PlatoDto platoDto = platosRepo.getPlato(nombre);
    return caloriasService.getIngredienteMasCalorico(platoDto);
  }
}
