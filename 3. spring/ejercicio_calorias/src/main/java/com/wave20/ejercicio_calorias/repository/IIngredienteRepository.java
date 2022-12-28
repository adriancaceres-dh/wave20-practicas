package com.wave20.ejercicio_calorias.repository;


import com.wave20.ejercicio_calorias.model.Ingrediente;

import java.util.Optional;

public interface IIngredienteRepository {
    Optional<Ingrediente> obtenerIngredientePorNombre(String nombre);
}