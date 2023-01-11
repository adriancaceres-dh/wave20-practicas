package com.bootcamp.ejercicio_calorias.repository;

import com.bootcamp.ejercicio_calorias.model.Dish;

import java.util.List;

public interface IDishRepository {
    List<Dish> findByName(String name);
}
