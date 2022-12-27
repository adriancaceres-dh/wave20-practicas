package com.bootcamp.contadorcalorias.repo;

import com.bootcamp.contadorcalorias.model.Dish;
import com.bootcamp.contadorcalorias.model.Ingredient;

import java.util.List;

public interface IRepoFood {
    Dish findDish (String name);
    List<Dish> getAllDish ();
}
