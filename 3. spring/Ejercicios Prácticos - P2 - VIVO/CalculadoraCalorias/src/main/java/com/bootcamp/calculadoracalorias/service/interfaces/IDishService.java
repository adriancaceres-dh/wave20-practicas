package com.bootcamp.calculadoracalorias.service.interfaces;

import com.bootcamp.calculadoracalorias.dto.response.DishDto;
import com.bootcamp.calculadoracalorias.dto.response.FoodDto;

import java.util.List;

public interface IDishService {

    public double calcularTotalCalorias(String name, double weight);
    public List<FoodDto> listarIngredientes(String name);

    public FoodDto buscarIngredienteMasCalorias(String name);

    public List<DishDto> listarPlatos();

}
