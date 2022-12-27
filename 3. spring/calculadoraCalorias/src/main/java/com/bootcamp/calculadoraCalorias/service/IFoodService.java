package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.dto.DishDTO;
import com.bootcamp.calculadoraCalorias.dto.RequestDTO;
import com.bootcamp.calculadoraCalorias.dto.ResponseDTO;

import java.util.List;

public interface IFoodService {
    public DishDTO getDish(RequestDTO dishRequest);
    public int getDishTotalCalories(DishDTO dish);
    public ResponseDTO getDishesInfo(List<RequestDTO> dishRequest);
}
