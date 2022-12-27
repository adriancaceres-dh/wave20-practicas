package com.bootcamp.contadorcalorias.service;

import com.bootcamp.contadorcalorias.dto.DishDTOResponse;
import com.bootcamp.contadorcalorias.dto.IngredientDTO;
import com.bootcamp.contadorcalorias.model.Dish;
import com.bootcamp.contadorcalorias.model.Ingredient;
import com.bootcamp.contadorcalorias.repo.RepoFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService implements IDishService{

    @Autowired
    private RepoFood repoFood;

    @Override
    public DishDTOResponse getDish(String name) {
        Dish dish = repoFood.findDish(name);

        if (dish == null) return null;

        IngredientDTO mostCaloricIngredient = listIngredients(dish).stream().max(Comparator.comparingInt(IngredientDTO::getCalories)).get();

        return new DishDTOResponse(countCalories(dish), listIngredients(dish), mostCaloricIngredient);
    }

    @Override
    public Integer countCalories(Dish dish) {
        return dish.getIngredients().stream().map(Ingredient::getCalories).reduce(0, Integer::sum);
    }

    @Override
    public List<IngredientDTO> listIngredients(Dish dish) {
        return dish.getIngredients().stream().map(i -> new IngredientDTO(i.getName(), i.getCalories())).collect(Collectors.toList());
    }


}
