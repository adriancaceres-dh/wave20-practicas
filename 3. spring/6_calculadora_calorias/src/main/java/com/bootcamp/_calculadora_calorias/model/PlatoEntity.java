package com.bootcamp._calculadora_calorias.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlatoEntity {

    private String nombre;
    private List<IngredientEntity> ingredientes;


}
