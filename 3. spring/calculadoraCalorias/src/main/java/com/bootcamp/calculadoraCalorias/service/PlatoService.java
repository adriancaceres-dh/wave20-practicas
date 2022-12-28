package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.model.Ingrediente;
import com.bootcamp.calculadoraCalorias.model.Plato;
import com.bootcamp.calculadoraCalorias.repository.PlatoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepositoryImpl platoRepository;

    public Integer totalPorPlato(String nombre){
        Plato plato = buscarPlato(nombre);
        return plato.getListaIngredientes().stream()
                .mapToInt(this::calcularCaloriasPorIng)
                .sum();
    }

    public Integer calcularCaloriasPorIng(Ingrediente ingrediente){
        if (ingrediente != null){
            ingrediente.setCalories((int) (ingrediente.getPeso() * ingrediente.getCalories() / 100.f));
            //ingrediente.setCalories(0);
        }

        assert ingrediente != null;
        return ingrediente.getCalories();
    }

    public Plato buscarPlato(String nombre){
        return platoRepository.getListaPlatos()
                .stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findAny()
                .orElse(null);
    }
}
