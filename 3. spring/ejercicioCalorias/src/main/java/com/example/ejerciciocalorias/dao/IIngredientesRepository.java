package com.example.ejerciciocalorias.dao;

import com.example.ejerciciocalorias.model.Ingrediente;

public interface IIngredientesRepository {

  public Ingrediente getIngrediente(String nombre);
}
