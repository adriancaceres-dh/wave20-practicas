package com.example.ejerciciocalorias.dao;

import com.example.ejerciciocalorias.dto.PlatoDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class PlatosRepo implements IPlatosRepo {

  private Map<String, PlatoDto> platos = new HashMap<>();

  @Override
  public PlatoDto getPlato(String nombre) {
    return platos.get(nombre);
  }

}
