package com.bootcamp.ejercicio_calorias.service;

import com.bootcamp.ejercicio_calorias.dto.DishDTO;
import com.bootcamp.ejercicio_calorias.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDishService {
    public List<DishDTO> getByName(String name);
}
