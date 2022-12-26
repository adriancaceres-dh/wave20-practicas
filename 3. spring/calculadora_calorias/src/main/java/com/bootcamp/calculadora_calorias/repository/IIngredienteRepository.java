package com.bootcamp.calculadora_calorias.repository;

import com.bootcamp.calculadora_calorias.model.Ingrediente;

import java.util.Optional;

public interface IIngredienteRepository {
    Optional<Ingrediente> obtenerIngredientePorNombre(String nombre);
}
