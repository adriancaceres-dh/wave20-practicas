package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository {
    private List<Plato> platos;

    public PlatoRepository() {
        platos = new ArrayList<>();
    }

    public Plato findByName(String name) {
        return platos.stream()
                .filter(plato -> plato.getName().equals(name))
                .findFirst().get();
    }
}
