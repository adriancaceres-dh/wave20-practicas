package com.example.ejercicio_calculadora_calorias.repository;

import com.example.ejercicio_calculadora_calorias.entity.Dish;
import com.example.ejercicio_calculadora_calorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class DishRepository implements IDishRepository{



    private IIngredientRepository iIngredientRepository;
    private List<Dish> dishes;


    public DishRepository() {

        iIngredientRepository = new IngredientRepository();
        dishes = new ArrayList<>();
        llenar();


    }

    public void llenar(){
        List<Ingredient> ingredients= new ArrayList<>();
        ingredients.add(iIngredientRepository.findByName("Granada"));
        ingredients.add(iIngredientRepository.findByName("Fresas"));
        ingredients.add(iIngredientRepository.findByName("Mango"));
        ingredients.add(iIngredientRepository.findByName("Manzana"));
        System.out.println("asdfasdf");
        dishes.add(new Dish("platillo1", ingredients,200));
        dishes.add(new Dish("platillo2", Arrays.asList(
                iIngredientRepository.findByName("Ajos"),
                iIngredientRepository.findByName("Alcachofas"),
                iIngredientRepository.findByName("Berros"),
                iIngredientRepository.findByName("Berenjena")
        ),300));
        dishes.add(new Dish("platillo3", Arrays.asList(
                iIngredientRepository.findByName("Yogur natural con fruta"),
                iIngredientRepository.findByName("Granada"),
                iIngredientRepository.findByName("Butifarra, salchicha fresca"),
                iIngredientRepository.findByName("Manzana")
        ),400));
    }


    @Override
    public Dish findByName(String name) {
        return dishes.stream().filter(e -> e.getName().equals(name)).findFirst().get();
    }
}
