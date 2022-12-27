package com.example.ejercicio_calculadora_calorias.service;

import com.example.ejercicio_calculadora_calorias.dto.response.DishResponseDto;
import com.example.ejercicio_calculadora_calorias.entity.Dish;
import com.example.ejercicio_calculadora_calorias.entity.Ingredient;
import com.example.ejercicio_calculadora_calorias.repository.DishRepository;
import com.example.ejercicio_calculadora_calorias.repository.IDishRepository;
import com.example.ejercicio_calculadora_calorias.repository.IIngredientRepository;
import com.example.ejercicio_calculadora_calorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DishService implements IDishService {

    @Autowired
    DishRepository dishRepository;

    public DishService() {
        System.out.println("heheheh");
    }

    @Override
    public DishResponseDto infoPlato(String name, double weight) {



        Dish dish = dishRepository.findByName(name);

        double totalCalorias = dish.getIngredients().stream().mapToDouble(e -> Double.parseDouble(e.getCalories())).sum();
        totalCalorias = totalCalorias*dish.getCaloriesPer100Gramos()*1;

        Ingredient ingredient = dish.getIngredients().stream().max(Comparator.
                comparingDouble(e -> Double.parseDouble(e.getCalories()))).get();

        DishResponseDto dishResponseDto = new DishResponseDto(
                dish.getName(),
                dish.getIngredients(),
                totalCalorias,
                ingredient
        );
        return dishResponseDto;
    }
}
