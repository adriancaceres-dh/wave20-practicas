package com.bootcamp.autos.repository;

import com.bootcamp.autos.model.Auto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository {
    private List<Auto> autos;
    public AutoRepository() {
        autos = new ArrayList<>();
        // simulamos datos (de la base de datos)
        Auto auto = Auto.builder()
                .id("1")
                .marca("Ford")
                .modelo("Fiesta")
                .build();
        autos.add(auto);
        Auto auto1 = new Auto("2","Chev","Algo");
        autos.add(auto1);
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public boolean agregar(Auto auto) {
        autos.add(auto);
        return true;
    }

}
