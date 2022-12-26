package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {
    List<Deporte> deportes;

    public DeporteRepository() {
       deportes = new ArrayList<>();
       deportes.add(new Deporte("Futbool","1"));
       deportes.add(new Deporte("Tenis","1"));
    }

    public List<Deporte> findSports() {
        return this.deportes;
    }


}
