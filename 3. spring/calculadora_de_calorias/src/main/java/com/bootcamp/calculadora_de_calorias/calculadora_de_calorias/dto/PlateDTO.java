package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto;

import java.util.List;

public class PlateDTO {
    private String name;
    private List<IngredientDTO> plate;
    private int calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientDTO> getPlate() {
        return plate;
    }

    public void setPlate(List<IngredientDTO> plate) {
        this.plate = plate;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public PlateDTO() {
    }

    public PlateDTO(String name, List<IngredientDTO> plate, int calories) {
        this.name = name;
        this.plate = plate;
        this.calories = calories;
    }
}
