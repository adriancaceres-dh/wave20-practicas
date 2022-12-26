package com.example.calorias.repository;

import com.example.calorias.model.Plato;

import java.util.List;

public interface PlatoRepositoryInterface {
    List<Plato> getAllPlatos();
    Plato getPlatoByName(String nombre);

}
