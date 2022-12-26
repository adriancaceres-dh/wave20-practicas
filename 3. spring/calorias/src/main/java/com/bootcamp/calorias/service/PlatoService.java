package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.IngredienteDto;
import com.bootcamp.calorias.dto.PlatoDto;
import com.bootcamp.calorias.dto.PlatoResponseDto;
import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.repository.IngredienteRepository;
import com.bootcamp.calorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {
    @Autowired
    private  PlatoRepository platoRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public PlatoResponseDto generateResponseForPlato(PlatoDto platoDto) {
        double totalCalories = platoDto.getIngredients().stream()
                .mapToDouble(ingredienteDto ->
                        ingredienteRepository.getIngredientCaloriesByName(ingredienteDto.getName())
                                * ingredienteDto.getWeight())
                .sum();

        IngredienteDto mostCaloricIngredient = platoDto.getIngredients().stream()
                .max(Comparator.comparingDouble(i -> ingredienteRepository.getIngredientCaloriesByName(i.getName())))
                .get();

        return new PlatoResponseDto(totalCalories, platoDto.getIngredients(), mostCaloricIngredient);
    }

    public List<PlatoResponseDto> generateResponseForPlatos(List<PlatoDto> platoDtoList) {
        return platoDtoList.stream().map(this::generateResponseForPlato).collect(Collectors.toList());
    }
}
