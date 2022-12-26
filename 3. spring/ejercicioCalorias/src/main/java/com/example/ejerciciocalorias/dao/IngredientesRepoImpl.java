package com.example.ejerciciocalorias.dao;

import com.example.ejerciciocalorias.model.Ingrediente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientesRepoImpl implements IIngredientesRepository {
  private List<Ingrediente> databaseIngredientes;

  public IngredientesRepoImpl() {
    ObjectMapper mapper = new ObjectMapper();
    try {
      databaseIngredientes = mapper.readValue(getClass().getResourceAsStream("/static/ingredientes.json"), mapper.getTypeFactory().constructCollectionType(List.class, Ingrediente.class));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Ingrediente getIngrediente(String name) {
    return databaseIngredientes.stream().filter(ingrediente -> ingrediente.getNombre().equals(name)).findFirst().orElse(null);
  }



}
