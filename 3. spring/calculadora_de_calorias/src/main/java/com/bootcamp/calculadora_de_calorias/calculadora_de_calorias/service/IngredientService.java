package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.service;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.IngredientDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository.IngredientRepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepositoryI ingredientRepositoryI;

    public IngredientService(IngredientRepositoryI ingredientRepositoryI) {
        this.ingredientRepositoryI = ingredientRepositoryI;
    }

    public List<IngredientDTO> getIngredients(){
        return ingredientRepositoryI.ingredients();
    }
}
