package com.example.ejercicio_calculadora_calorias.service;

import com.example.ejercicio_calculadora_calorias.dto.response.DishResponseDto;

public interface IDishService {

    DishResponseDto infoPlato(String name, double weight);
}
