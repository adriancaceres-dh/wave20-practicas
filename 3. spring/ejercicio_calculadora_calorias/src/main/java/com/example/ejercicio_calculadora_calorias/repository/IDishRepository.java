package com.example.ejercicio_calculadora_calorias.repository;

import com.example.ejercicio_calculadora_calorias.entity.Dish;

import java.util.List;

public interface IDishRepository {

    public Dish findByName(String name);

}
