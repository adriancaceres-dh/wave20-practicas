package com.bootcamp.calories.service;

import com.bootcamp.calories.dto.InfoDTO;
import com.bootcamp.calories.dto.IngredientDTO;
import com.bootcamp.calories.dto.RequestDTO;
import com.bootcamp.calories.model.Food;
import com.bootcamp.calories.model.Ingredient;
import com.bootcamp.calories.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService implements IMenuRepository{
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public InfoDTO infoFood(RequestDTO request) {
        Food searchFood= menuRepository.getMenu().stream().filter(m->m.getName()
                .equals(request.getName())).findFirst().get();

        if (searchFood==null){
            return null;
        }

        double totalCalories=request.getWeithgr()*menuRepository.getMenu().stream()
                .mapToInt(i-> i.getTotalCalories()).sum();

        String greatestIngedient=searchFood.getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories)).get().getName();

        List<IngredientDTO> ingredientDTO=searchFood.getIngredients().stream()
                .map(i->new IngredientDTO(i.getName(), i.getCalories())).collect(Collectors.toList());

        return new InfoDTO(searchFood.getName(),totalCalories,ingredientDTO,greatestIngedient);
    }
}
