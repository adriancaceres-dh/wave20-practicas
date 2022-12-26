package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.model.Ingrediente;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredienteRepository {

    public Ingrediente buscarIngrediente(String nombre);
}
