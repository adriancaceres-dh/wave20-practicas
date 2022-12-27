package com.example.ejercicio_calculadora_calorias.service;

import com.example.ejercicio_calculadora_calorias.dto.response.DishResponseDto;
import com.example.ejercicio_calculadora_calorias.entity.Dish;
import com.example.ejercicio_calculadora_calorias.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IIngredientService {

    public DishResponseDto inforPlato(String name, double weight);

}
