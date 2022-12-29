package com.bootcamp.contadorcalorias.repo;

import com.bootcamp.contadorcalorias.dto.DishDTOResponse;
import com.bootcamp.contadorcalorias.dto.IngredientDTO;
import com.bootcamp.contadorcalorias.model.Dish;
import com.bootcamp.contadorcalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepoFood implements IRepoFood{

    private final List<IngredientDTO> ingredientsDB;
    private final List<Dish> dishDB;

    // seprar repo en plato e ingredientes

    public RepoFood(List<Ingredient> database, List<Dish> dishDB) {
        this.dishDB = new ArrayList<>();
        this.ingredientsDB = loadDataBase();

        this.dishDB.add(new Dish("Espagueti", Arrays.asList(new Ingredient("Pasta",200),new Ingredient("Tomate",500))));
    }

    public Dish findDish (String name) {
        Optional<Dish> searchedDish = dishDB.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .findFirst();
        return searchedDish.orElse(null);
    }

    private List<IngredientDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
        List<IngredientDTO> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return ingredients;
    }
}
