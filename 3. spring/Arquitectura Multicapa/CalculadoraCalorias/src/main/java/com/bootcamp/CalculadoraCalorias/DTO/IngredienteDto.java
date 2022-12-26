package com.bootcamp.CalculadoraCalorias.DTO;

import lombok.Data;

@Data
public class IngredienteDto {
    private String name;
    private int calories;

    public IngredienteDto() {
    }

    public IngredienteDto(String nombre, int calorias) {
        this.name = nombre;
        this.calories = calorias;
    }
}
