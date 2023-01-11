package com.bootcamp.ejercicio_calorias.repository;

import com.bootcamp.ejercicio_calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


    @Repository
    public class IngredientRepository implements IIngredientRepository {
        private final List<Ingredient> database;

        public IngredientRepository() {
            this.database = loadDataBase();
        }

        @Override
        public Ingredient findAllByNameContains(String query) {
            return database.stream()
                    .filter(dish -> matchWith(query, dish)).findFirst().get();
        }

        private boolean matchWith(String query, Ingredient ingredient) {
            return ingredient.getName().toUpperCase().contains(query.toUpperCase());
        }

        public List<Ingredient> findAll(){
            return this.database;
        }
        private List<Ingredient> loadDataBase() {
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


