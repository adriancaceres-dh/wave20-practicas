package com.bootcamp.Calculadora.de.calorias.repository;

import com.bootcamp.Calculadora.de.calorias.model.Ingrediente;
import com.bootcamp.Calculadora.de.calorias.model.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PlatosRepository implements IPlatosRepository {
    @Autowired
    IngredientesRepositoryImpl ingredientesRepository;

    @Override
    public List<Plato> platos() {
        List<Ingrediente> ingredietes1 = new ArrayList<>();
        ingredietes1.add(ingredientesRepository.ingredintes().get(0));
        ingredietes1.add(ingredientesRepository.ingredintes().get(2));
        ingredietes1.add(ingredientesRepository.ingredintes().get(6));

        List<Ingrediente> ingredietes2 = new ArrayList<>();
        ingredietes2.add(ingredientesRepository.ingredintes().get(7));
        ingredietes2.add(ingredientesRepository.ingredintes().get(10));
        ingredietes2.add(ingredientesRepository.ingredintes().get(8));

        List<Ingrediente> ingredietes3 = new ArrayList<>();
        ingredietes3.add(ingredientesRepository.ingredintes().get(16));
        ingredietes3.add(ingredientesRepository.ingredintes().get(11));
        ingredietes3.add(ingredientesRepository.ingredintes().get(17));

        Plato p1 = new Plato("Tallarines", ingredietes1);
        Plato p2 = new Plato("Asado", ingredietes2);
        Plato p3 = new Plato("Porotos", ingredietes3);

        List<Plato> platos = new ArrayList<>();
        platos.add(p1);
        platos.add(p2);
        platos.add(p3);

        return platos;
    }
}
