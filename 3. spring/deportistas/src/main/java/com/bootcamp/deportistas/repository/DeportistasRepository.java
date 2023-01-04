package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeportistasRepository implements DeportistasRepositoryInterface{

    private Map<Persona, Deporte> deportistas;

    public DeportistasRepository() {
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

    @Override
    public List<Deporte> todosLosDeportes() {
        return deportistas.
    }

    @Override
    public List<Persona> todasLasPersonas() {
        return null;
    }
}
