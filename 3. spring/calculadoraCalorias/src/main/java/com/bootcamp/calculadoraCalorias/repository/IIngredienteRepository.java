package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.model.Ingrediente;

public interface IIngredienteRepository {
    public Ingrediente buscarIngrediente(String nombre);
}
