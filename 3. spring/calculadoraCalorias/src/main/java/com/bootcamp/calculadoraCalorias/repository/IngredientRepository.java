package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository {
    final List<Ingredient> ingredients;

    public IngredientRepository() {
       this.ingredients = loadDataBase();

   }

   public List<Ingredient> getIngredients() {
        return this.ingredients;}

   public Ingredient getIngredients(String ingredientName) {
       return this.ingredients.stream()
               .filter(i -> i.getName().equals(ingredientName)).findFirst().orElse(null);
               }

   List<Ingredient> loadDataBase() {
       File file = null;
       try {
           file = ResourceUtils.getFile("classpath:food.json");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       ObjectMapper objectMapper = new ObjectMapper();
       TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
       List<Ingredient> ingredients = null;
       try {
           ingredients = objectMapper.readValue(file, typeRef);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return ingredients;
    }

}
