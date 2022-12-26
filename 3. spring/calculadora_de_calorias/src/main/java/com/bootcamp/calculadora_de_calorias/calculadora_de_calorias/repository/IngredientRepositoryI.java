package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.IngredientDTO;

import java.util.List;

public interface IngredientRepositoryI {
    List<IngredientDTO> ingredients();
}

