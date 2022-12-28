package com.example.starwars.dao;

import com.example.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPersonajesJson implements IRepositorioPersonajes {

  private final List<Personaje> database;

  public RepositorioPersonajesJson() {
    this.database = cargarDatabase();
  }

  @Override
  public List<Personaje> buscarPersonaje(String name) {
    List<Personaje> resultado = new ArrayList<>();
    for (Personaje personaje : database) {
      if (personaje.getName().toLowerCase().contains(name.toLowerCase())) {
        resultado.add(personaje);
      }
    }
    return resultado;
  }

  public List<Personaje> cargarDatabase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:starwars_characters.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
    List<Personaje> characters = null;
    try {
      characters = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return characters;
  }
}

