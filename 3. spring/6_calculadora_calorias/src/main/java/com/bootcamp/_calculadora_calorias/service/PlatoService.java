package com.bootcamp._calculadora_calorias.service;

import com.bootcamp._calculadora_calorias.dto.IngredienteDto;
import com.bootcamp._calculadora_calorias.model.IngredientEntity;
import com.bootcamp._calculadora_calorias.model.PlatoEntity;
import com.bootcamp._calculadora_calorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {
    @Autowired
    PlatoRepository platoRepository;
    public Double calculateTotalCalories(String name, double weight){
        PlatoEntity plato=platoRepository.getAll().stream()
                .filter(platoEntity -> platoEntity.getNombre().equalsIgnoreCase(name))
                .findFirst().orElse(null);
        if(plato!=null){
            return plato.getIngredientes().stream()
                    .mapToInt(x->x.getCalories())
                    .sum()*weight;
        }else{
            return 0.0;
        }
    }

    public List<IngredienteDto> obtenerIngredientes(String name){
        PlatoEntity plato=platoRepository.getAll().stream()
                .filter(platoEntity -> platoEntity.getNombre().equalsIgnoreCase(name))
                .findFirst().orElse(null);
        if(plato!=null){
            return plato.getIngredientes().stream()
                    .map(p->new IngredienteDto(p.getName(),p.getCalories()))
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }

    public IngredienteDto obtenerIngredienteMasCalorias(String name){
        PlatoEntity plato=platoRepository.getAll().stream()
                .filter(platoEntity -> platoEntity.getNombre().equalsIgnoreCase(name))
                .findFirst().orElse(null);
        if(plato!=null) {
            return plato.getIngredientes().stream()
                    .sorted((x,y)->Integer.compare(y.getCalories(),x.getCalories()))
                    .map(ingredientEntity -> new IngredienteDto(ingredientEntity.getName(),ingredientEntity.getCalories()))
                    .findFirst().get();
        }else {
            return null;
        }

    }

}
