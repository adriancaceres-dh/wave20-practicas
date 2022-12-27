package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.model.Dish;
import com.bootcamp.calculadoracalorias.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {

    List<Dish> platos;
    FoodRepository foodRepository;

    public DishRepository() {
        platos = new ArrayList<>();
        foodRepository = new FoodRepository();
        agregarPlatoRandom();
    }

    public int agregarPlatoRandom() {
        int cantPlatos = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < cantPlatos; i++) {
            List<Food> ingredientes1 = new ArrayList<>();
            for (int j = 0; j < foodRepository.cantIngredientes(); j++) {
                ingredientes1.add(foodRepository.agregarIngredienteRandom());
            }
            Dish plato1 = Dish.builder()
                    .name("Plato " + (i + 1))
                    .ingredients(ingredientes1)
                    .build();
            plato1.calcularTotalCalorias();
            platos.add(plato1);
        }
        return cantPlatos;
    }

    public List<Dish> listarPlatos() {
        return platos;
    }
}
