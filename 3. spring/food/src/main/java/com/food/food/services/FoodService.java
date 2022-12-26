package com.food.food.services;

import com.food.food.dtos.Ingredient;
import com.food.food.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodRepository repository;

    public List<Ingredient> findAll(){
        return repository.findAll();
    }

    public Optional<Ingredient> findMaxCaloriesIng(){
        return repository.findAll().stream().max(Comparator.comparingInt(f->f.getCalories())).stream().findAny();
    }
}
