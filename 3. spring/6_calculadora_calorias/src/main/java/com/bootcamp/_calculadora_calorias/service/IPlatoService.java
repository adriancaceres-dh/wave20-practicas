package com.bootcamp._calculadora_calorias.service;

import com.bootcamp._calculadora_calorias.dto.IngredienteDto;

import java.util.List;

public interface IPlatoService {

    public Double calculateTotalCalories(String name, double weight);
    public List<IngredienteDto> obtenerIngredientes(String name);
    public IngredienteDto obtenerIngredienteMasCalorias(String name);
}
