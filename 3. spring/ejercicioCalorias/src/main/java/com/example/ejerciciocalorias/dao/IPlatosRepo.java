package com.example.ejerciciocalorias.dao;

import com.example.ejerciciocalorias.dto.PlatoDto;


public interface IPlatosRepo {
  public PlatoDto getPlato(String nombre);
}
