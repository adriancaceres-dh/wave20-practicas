package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {

    List<Deporte> deportes = new ArrayList<>();

    public DeporteRepository() {
        this.deportes = new ArrayList<>();
        deportes.add(new Deporte("Rugby","Riesgo Alto"));
        deportes.add(new Deporte("Baloncesto","Riesgo Bajo"));
        deportes.add(new Deporte("Ciclismo","Riesgo Moderado"));
        deportes.add(new Deporte("Alpinismo","Riesgo Alto"));
        deportes.add(new Deporte("Ajedrez","Riesgo Bajo"));
        deportes.add(new Deporte("Futbol","Riesgo Moderado"));
    }

    public List<Deporte> findAll(){
        return deportes;
    }

    public Deporte findByName(String name){
        Deporte deporte = deportes.stream().filter(e -> e.getNombre().equals(name)).findFirst().orElse(new Deporte());
        return deporte;
    }
}
