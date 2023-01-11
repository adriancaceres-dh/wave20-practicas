package com.bootcamp.ejercicio_calorias.service;


import com.bootcamp.ejercicio_calorias.dto.DishDTO;
import com.bootcamp.ejercicio_calorias.model.Dish;
import com.bootcamp.ejercicio_calorias.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DishService implements IDishService
{
    @Autowired
    private IDishRepository dishRepository;

    @Override
    public List<DishDTO> getByName(String name) {
        List<Dish> dishList = dishRepository.findByName(name);
        return dishList.stream().map(x->new DishDTO(x.getIngredients()
                ,x.getIngredients().stream().mapToDouble(c->c.getCalories()).sum(),
                x.getIngredients().stream().max(Comparator.comparingDouble(c->c.getCalories())).get()
                )).collect(Collectors.toList());
    }
}
