package com.bootcamp.calculadora_calorias.repository;


import com.wave20.ejercicio_calorias.model.Plato;

import java.util.Optional;

public interface IPlatoRepository {
    Optional<Plato> obtenerPlato(String nombre);
}