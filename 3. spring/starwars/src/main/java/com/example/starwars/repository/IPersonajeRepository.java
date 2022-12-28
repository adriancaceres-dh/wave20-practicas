package com.example.starwars.repository;


import com.example.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> obtenerPersonajes();
}