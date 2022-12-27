package com.bootcamp._calculadora_calorias.repository;

import com.bootcamp._calculadora_calorias.model.IngredientEntity;
import com.bootcamp._calculadora_calorias.model.PlatoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PlatoRepository {
    private IngredientRepository ingredientRepository;
    private List<PlatoEntity> listaPlatos;

    public PlatoRepository(){
        ingredientRepository=new IngredientRepository();
        List<IngredientEntity> listaIngredientes= new ArrayList<>(){{
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
        }};


        List<IngredientEntity> listaIngredientes2= new ArrayList<>(){{
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
        }};


        List<IngredientEntity> listaIngredientes3= new ArrayList<>(){{
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
        }};

        List<IngredientEntity> listaIngredientes4= new ArrayList<>(){{
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
        }};

        List<IngredientEntity> listaIngredientes5= new ArrayList<>(){{
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
            add(ingredientRepository.getRandom());
        }};

        PlatoEntity plato= PlatoEntity.builder()
                .nombre("plato")
                .ingredientes(listaIngredientes)
                .build();


        PlatoEntity plato2= PlatoEntity.builder()
                .nombre("plato2")
                .ingredientes(listaIngredientes2)
                .build();

        PlatoEntity plato3= PlatoEntity.builder()
                .nombre("plato3")
                .ingredientes(listaIngredientes3)
                .build();

        PlatoEntity plato4= PlatoEntity.builder()
                .nombre("plato4")
                .ingredientes(listaIngredientes4)
                .build();

        PlatoEntity plato5= PlatoEntity.builder()
                .nombre("plato5")
                .ingredientes(listaIngredientes5)
                .build();


        this.listaPlatos= new ArrayList<>(){{
            add(plato);
            add(plato2);
            add(plato3);
            add(plato4);
            add(plato5);
        }};
    }

    public List<PlatoEntity> getAll(){
        return listaPlatos;
    }
}
