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
public class DishService {

    @Autowired
    private RepoFood repoFood;
    public Integer countCalories(String name, Integer weight) {
        Dish findDish = findDish(name);
        if (findDish != null  && weight != null) return ((findDish.getIngredients().stream()
                .map(Ingredient::getCalories)
                .reduce(0, Integer::sum))*weight)/100;
        if(findDish != null && weight == null) return findDish.getIngredients().stream()
                .map(Ingredient::getCalories)
                .reduce(0, Integer::sum);
        return null;
    }

    public List<IngredientDTO> listIngredients(String name) {
        Dish findDish = findDish(name);
        if(findDish != null) return findDish.getIngredients().stream()
                .map(i -> new IngredientDTO(i.getName(), i.getCalories()))
                .collect(Collectors.toList());
        return null;
    }

    public IngredientDTO mostCaloricIngredient(String name) {
        Dish findDish = findDish(name);
        return findDish.getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .map(i -> new IngredientDTO(i.getName(),i.getCalories()))
                .orElse(null);
    }

    private Dish findDish (String name) {
        return repoFood.findDish(name);
    }
}
