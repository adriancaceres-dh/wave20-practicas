package com.bootcamp.ejercicio_calorias.repository;

import com.bootcamp.ejercicio_calorias.model.Dish;
import com.bootcamp.ejercicio_calorias.model.Ingredient;
import com.bootcamp.ejercicio_calorias.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DishRepository implements IDishRepository{
    private List<Dish> dishList;


    public DishRepository(IIngredientRepository ingredientRepository){
        dishList = new ArrayList<>();

        List<Ingredient> ingredientes = new ArrayList<>();
        Ingredient acelga = ingredientRepository.findAllByNameContains("Acelgas");
        Ingredient ajo = ingredientRepository.findAllByNameContains("Ajos");

        ingredientes.add(acelga);
        ingredientes.add(ajo);


        Dish plato = new Dish(ingredientes,"plato");


        List<Ingredient> ingredients2 = new ArrayList<>();
        Ingredient col = ingredientRepository.findAllByNameContains("Col");
        Ingredient nabo = ingredientRepository.findAllByNameContains("Nabos");

        ingredients2.add(col);
        ingredients2.add(nabo);
        ingredients2.add(ajo);

        Dish plato2 = new Dish(ingredients2,"plato2");

        dishList.add(plato);
        dishList.add(plato2);

    }

    @Override
    public List<Dish> findByName(String name) {
        return dishList.stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
    }
}
