package com.example.starwars.dao;

import com.example.starwars.model.Personaje;

import java.util.List;

public interface IRepositorioPersonajes {
  public List<Personaje> buscarPersonaje(String name);
}
