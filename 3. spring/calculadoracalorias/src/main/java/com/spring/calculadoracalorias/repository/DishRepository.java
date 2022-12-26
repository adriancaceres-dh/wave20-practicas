package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.model.Dish;
import com.spring.calculadoracalorias.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {

    public List<Dish> dishes = loadData();

    public Dish findDish(String nameDish){
        return dishes.stream().filter(d -> d.getName().equals(nameDish)).findAny().orElse(null);
    }
    private List<Dish> loadData() {
        dishes = new ArrayList<>();

        dishes.add(Dish.builder().name("plato 1").weight(40).ingredients(List.of("Mandarinas", "Grosella", "Leche de cabra")).build());
        dishes.add(Dish.builder().name("plato 2").weight(50).ingredients(List.of("Leche en polvo entera", "Requesón", "Chicharrón")).build());

        return dishes;
    }
}
