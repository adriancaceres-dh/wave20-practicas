package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.IngredentDTO;
import com.spring.calculadoracalorias.model.Dish;
import com.spring.calculadoracalorias.model.Ingredient;
import com.spring.calculadoracalorias.repository.DishRepository;
import com.spring.calculadoracalorias.repository.IngredientsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DishService implements IDishService{
    @Autowired
    public DishRepository dishRepository;
    @Autowired
    public IngredientsRepository ingredientsRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public double getCaloriesDish(String nameDish) {
        Dish dish = dishRepository.findDish(nameDish);
        double calories = 0d;
        for(String ingredentName : dish.getIngredients()){
            Ingredient ingredent = ingredientsRepository.findIngredent(ingredentName);
            if(!Objects.isNull(ingredent)){
                calories += ingredent.getCalories();
            }
        }
        return calories;
    }

    @Override
    public String getIngredentsCaloriesDish(String nameDish) {
        Dish dish = dishRepository.findDish(nameDish);
        StringBuilder stringBuilder = new StringBuilder();
        for(String ingredentName : dish.getIngredients()){
            Ingredient ingredent = ingredientsRepository.findIngredent(ingredentName);
            if(!Objects.isNull(ingredent)){
                stringBuilder.append(modelMapper.map(ingredent, IngredentDTO.class).toString());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public IngredentDTO getIngredentMostCalories(String nameDish) {
        Dish dish = dishRepository.findDish(nameDish);
        Ingredient ingredentMostCalories = new Ingredient();
        for(String ingredentName : dish.getIngredients()){
            Ingredient ingredent = ingredientsRepository.findIngredent(ingredentName);
            if(!Objects.isNull(ingredent) && ingredent.getCalories() > ingredentMostCalories.getCalories()){
                ingredentMostCalories = ingredent;
            }
        }
        return modelMapper.map(ingredentMostCalories, IngredentDTO.class);
    }

}
