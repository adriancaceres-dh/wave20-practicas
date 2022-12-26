package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.model.Ingrediente;
import com.bootcamp.calculadoraCalorias.model.Plato;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class PlatoRepository implements IPlatoRepository{

    List<Plato> listaPlatos;

    @Autowired
    IngredienteRepositoryImpl ingredienteRepository;

    public PlatoRepository() {
        ingredienteRepository = new IngredienteRepositoryImpl();
        listaPlatos = List.of(
            new Plato("Pizza",300,List.of(
                    /*ingredienteRepository.buscarIngrediente("Harina de trigo refinada"),ingredienteRepository.buscarIngrediente("Queso crema"),
                    ingredienteRepository.buscarIngrediente("Aceitunas verdes"),ingredienteRepository.buscarIngrediente("Salsa de tomate en conserva")*/
                    new Ingrediente("Harina de trigo refinada",220,150), new Ingrediente("Queso Crema",350,75),
                    new Ingrediente("Aceitunas verdes",50,25), new Ingrediente("Salsa de tomate en conserva",120,50)
            ))
        );
    }
}
