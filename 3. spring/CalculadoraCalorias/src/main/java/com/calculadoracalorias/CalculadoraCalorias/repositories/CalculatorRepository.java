package com.calculadoracalorias.CalculadoraCalorias.repositories;

import com.calculadoracalorias.CalculadoraCalorias.dto.FoodDto;

import java.util.List;

public interface CalculatorRepository {
    List<FoodDto> findAllFood();
}
