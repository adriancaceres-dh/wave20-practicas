package com.example.ejercicio_concesionaria_de_autos.repository;

import com.example.ejercicio_concesionaria_de_autos.entity.Auto;

import java.time.LocalDate;
import java.util.List;

public class AutoRepository implements  IAutoRepository{

    List<Auto> autos;

    public AutoRepository(){}

    @Override
    public List<Auto> findAll() {
        return null;
    }

    @Override
    public void save(Auto auto) {

    }

    @Override
    public List<Auto> findByDate(LocalDate minDate, LocalDate maxLocalDate) {
        return null;
    }

    @Override
    public List<Auto> findByPrice(double minPrice, double MaxPrice) {
        return null;
    }

    @Override
    public Auto findById(long id) {
        return null;
    }
}
