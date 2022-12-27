package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.dto.DishDTO;
import com.bootcamp.calculadoraCalorias.dto.IngredientDTO;
import com.bootcamp.calculadoraCalorias.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepository {

    Dish asado = Dish.builder()
            .name("Asado")
            .ingredients(List.of("Tira de asado"))
            .build();

    Dish pizza = Dish.builder()
            .name("Pizza")
            .ingredients( Arrays.asList("Harina de maíz", "Queso mozzarella", "Anchoas"))
            .build();

    List<Dish> menu = Arrays.asList(pizza,asado);

    public DishRepository() {
        // Default constructor
    }

    public List<Dish> getMenu(){
        return menu;
    }

    public Dish getDish(String dishName){
        return menu.stream().filter(d -> d.getName().equals(dishName)).findFirst().orElse(null);
    }
}
