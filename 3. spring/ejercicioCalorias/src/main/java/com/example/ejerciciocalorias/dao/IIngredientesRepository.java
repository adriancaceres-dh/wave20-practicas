package com.example.ejerciciocalorias.dao;

import com.example.ejerciciocalorias.dto.IngredienteDto;
import com.example.ejerciciocalorias.model.Ingrediente;

public interface ICaloriasRepository {

  public Ingrediente getIngrediente(String nombre);
}
