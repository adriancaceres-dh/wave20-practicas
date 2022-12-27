package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dto.response.DishDto;
import com.bootcamp.calculadoracalorias.dto.response.FoodDto;
import com.bootcamp.calculadoracalorias.model.Dish;
import com.bootcamp.calculadoracalorias.repository.DishRepository;
import com.bootcamp.calculadoracalorias.service.interfaces.IDishService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService implements IDishService {

    @Autowired
    DishRepository dishRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public double calcularTotalCalorias(String name, double weight) {
        Dish plato = buscarPlatoPorNombre(name);
        if (plato != null) {
            return plato.calcularTotalCalorias() * weight;
        }
        return 0;
    }

    @Override
    public List<FoodDto> listarIngredientes(String name) {
        Dish plato = buscarPlatoPorNombre(name);
        if (plato != null) {
            return plato.getIngredients().stream().map(p -> mapper.map(p, FoodDto.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public FoodDto buscarIngredienteMasCalorias(String name) {
        Dish plato = buscarPlatoPorNombre(name);
        if (plato != null) {
            return plato.getIngredients().stream().map(i -> mapper.map(i, FoodDto.class))
                    .sorted(Comparator.comparing(x -> x.getCalories(), Comparator.reverseOrder()))
                    .findFirst().orElse(null);
        }
        return null;
    }

    public Dish buscarPlatoPorNombre(String name) {
        return dishRepository.listarPlatos().stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    @Override
    public List<DishDto> listarPlatos() {
        return dishRepository.listarPlatos().stream().map(p -> mapper.map(p, DishDto.class)).collect(Collectors.toList());
    }
}
