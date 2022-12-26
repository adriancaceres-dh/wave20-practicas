package com.example.calc.repository;

import com.example.calc.model.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    List<Ingrediente> loadDataBase();
    List<Ingrediente> getIngredientes();
}
