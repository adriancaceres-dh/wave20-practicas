package com.bootcamp._calculadora_calorias.repository;

import com.bootcamp._calculadora_calorias.model.PlatoEntity;

import java.util.List;

public interface IPlatoRepository {

    public List<PlatoEntity> getAll();

}
