package com.example.ejercicio_covid19.repository;

import com.example.ejercicio_covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class RepositorySintoma {

    private List<Sintoma> sintomas;

    public RepositorySintoma(){
        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma(0001,"Fiebre","Alto"));
        sintomas.add(new Sintoma(0002,"Fatiga","Alto"));
        sintomas.add(new Sintoma(0003,"Dolor muscular","Medio"));
        sintomas.add(new Sintoma(0004,"Dificultad para respirar","Alto"));
        sintomas.add(new Sintoma(0005,"Tos","bajo"));
        sintomas.add(new Sintoma(0006,"Congestión","bajo"));
    }

    public List<Sintoma> findAll(){
        return  sintomas;
    }

    public Sintoma findByName(String name){
        return sintomas.stream().filter(e -> e.getNombre().equals(name)).findFirst().get();
    }
}
