package com.bootcamp.prueba.repository;

import com.bootcamp.prueba.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    List<Personaje> getAll();
}
