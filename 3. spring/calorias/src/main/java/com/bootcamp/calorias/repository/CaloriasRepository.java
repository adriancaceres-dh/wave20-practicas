package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;

public interface CaloriasRepository {

    Ingrediente getIngredienteByName(String name);

}
