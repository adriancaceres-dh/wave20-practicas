package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.dto.IngredientDTO;
import com.bootcamp.calculadoraCalorias.dto.DishDTO;
import com.bootcamp.calculadoraCalorias.dto.RequestDTO;
import com.bootcamp.calculadoraCalorias.dto.ResponseDTO;
import com.bootcamp.calculadoraCalorias.model.Dish;
import com.bootcamp.calculadoraCalorias.repository.IngredientRepository;
import com.bootcamp.calculadoraCalorias.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService {

   @Autowired
   public IngredientRepository ingredientRepository;

   @Autowired
   public DishRepository dishRepository;

   public DishDTO getDish(RequestDTO dishRequest){

           Dish dish = dishRepository.getDish(dishRequest.getName());

           int ingredientsCount = dish.getIngredients().size();
           int weight = dishRequest.getWeightInGrams();

           DishDTO dishDTO = DishDTO.builder().name(dish.getName())
                   .ingredient(dish.getIngredients()
                           .stream()
                           .map(i -> IngredientDTO.builder()
                                   .caloriesIn100Gr(ingredientRepository.getIngredients(i).getCalories())
                                   .caloriesSubtotal(
                                           (int) Math.ceil(ingredientRepository.getIngredients(i).getCalories()
                                                   * (weight / 100.0 / ingredientsCount)
                                           )
                                   )
                                   .name(i)
                                   .build())
                           .collect(Collectors.toList())).build();
           dishDTO.setTotalCalories(getDishTotalCalories(dishDTO));
       return dishDTO;
   }

   public int getDishTotalCalories(DishDTO dish){
       return dish.getIngredient().stream().map(IngredientDTO::getCaloriesSubtotal).reduce(0, Integer::sum);
   }

    public ResponseDTO getDishesInfo(List<RequestDTO> dishRequest){
        List<DishDTO> dishes = new ArrayList<>();
        dishRequest.forEach(d -> dishes.add(getDish((d))));
        return ResponseDTO.builder().Dishes(dishes).build();
    }
}
