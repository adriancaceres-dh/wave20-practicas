package com.bootcamp.calorias.dto;

import com.bootcamp.calorias.model.Ingrediente;
import lombok.Getter;

@Getter
public class IngredienteDto {
    private String name;
    private double weight;

    public IngredienteDto(){};

    public IngredienteDto(Ingrediente ingrediente, double weight) {
        name = ingrediente.getName();
        this.weight = weight;
    }
}
