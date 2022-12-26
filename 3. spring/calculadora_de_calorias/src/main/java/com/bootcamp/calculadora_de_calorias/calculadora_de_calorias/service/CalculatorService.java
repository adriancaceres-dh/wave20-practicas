package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.service;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.IngredientDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.PlateDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository.IngredientRepositoryI;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository.PlateRepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalculatorService {
    private final IngredientRepositoryI ingredientRepositoryI;
    private final PlateRepositoryI plateRepositoryI;

    public CalculatorService(IngredientRepositoryI ingredientRepositoryI, PlateRepositoryI plateRepositoryI) {
        this.ingredientRepositoryI = ingredientRepositoryI;
        this.plateRepositoryI = plateRepositoryI;
    }

    public List<IngredientDTO> getIngredients(){
        return ingredientRepositoryI.ingredients();
    }
    public List<PlateDTO> getPlates(){
        return plateRepositoryI.getPlates();
    }
}
