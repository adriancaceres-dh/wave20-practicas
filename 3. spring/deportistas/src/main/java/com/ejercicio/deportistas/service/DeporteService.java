package com.ejercicio.deportistas.service;

import com.ejercicio.deportistas.model.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeporteService {

    private List<Deporte> deportes;

    public DeporteService(){
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol","Intermedio"));
        deportes.add(new Deporte("Hamboll","Profecional"));
        deportes.add(new Deporte("Tenis","Principiante"));
    }

    public List<Deporte> todos(){
        return deportes;
    }

    public List<Deporte> obrenerDeportePorNombre(String nombre){
        return this.deportes.stream().filter(d->d.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());

    }
}
