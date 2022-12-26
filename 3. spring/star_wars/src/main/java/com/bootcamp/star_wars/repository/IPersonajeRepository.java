package com.bootcamp.star_wars.repository;

import com.bootcamp.star_wars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> obtenerPersonajes(String nombre);
}
