package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeportistasService {

    private Map<Persona, Deporte> deportistas;

    public DeportistasService(){

        deportistas = new HashMap<>();

        deportistas.put(new Persona("Lionel", "Messi", 35),new Deporte("futbol", "Alto"));
        deportistas.put(new Persona("Bart", "Simpson", 10),new Deporte("futbol", "Bajo"));

        deportistas.put(new Persona("Manu", "Ginobili", 35),new Deporte("basquetbol", "Alto"));
        deportistas.put(new Persona("Homero", "Simpson", 36),new Deporte("basquetbol", "Bajo"));

        deportistas.put(new Persona("Michael", "Phelps", 37),new Deporte("natacion", "Alto"));
        deportistas.put(new Persona("Lisa", "Simpson", 8),new Deporte("natacion", "Bajo"));

        deportistas.put(new Persona("Juan Martin", "Del Potro", 34),new Deporte("tenis", "Alto"));
        deportistas.put(new Persona("Marge", "Simpson", 36),new Deporte("tenis", "Bajo"));

    }

    public List<String> todosLosDeportes () {

        List<String> listaDeportes = new ArrayList<>();
        //deportes.forEach( (k,v) -> listaDeportes.add(k));
        listaDeportes.addAll(deportistas.forEach((k,v)->v.getNombre());
        listaDeportes.stream().distinct().
        return listaDeportes;
    }



}
