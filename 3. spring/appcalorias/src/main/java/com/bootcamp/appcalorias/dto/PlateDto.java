package com.bootcamp.appcalorias.dto;

import com.bootcamp.appcalorias.model.Ingredient;

import java.util.List;

public class PlateDto {
    private String name;
    private int totalCalories;
    private IngredientDto mostCaloriesIngridient;
    private List<IngredientDto> ingredientList;
    public PlateDto(){}

    public PlateDto(String name, int totalCalories, IngredientDto mostCaloriesIngridient, List<IngredientDto> ingredientList) {
        this.name = name;
        this.totalCalories = totalCalories;
        this.mostCaloriesIngridient = mostCaloriesIngridient;
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public IngredientDto getMostCaloriesIngridient() {
        return mostCaloriesIngridient;
    }

    public void setMostCaloriesIngridient(IngredientDto mostCaloriesIngridient) {
        this.mostCaloriesIngridient = mostCaloriesIngridient;
    }

    public List<IngredientDto> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientDto> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
