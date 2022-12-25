package com.bootcamp.Aplicacion.controller;
import com.bootcamp.Aplicacion.model.*;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesController {

    @GetMapping(path="/findSports")
    public String findSports(){
        List<Deporte> deportes = crearDeportes();
        String json = new Gson().toJson(deportes);
        return json;
    }

    @GetMapping(path="/findSports/{name}")
    public ResponseEntity<String> findSports(@PathVariable String name){
        List<Deporte> deportes = crearDeportes();
        String deporteEncontrado = deportes.stream().filter(d->d.getName().toLowerCase().equals(name)).findAny().toString();
        return new ResponseEntity<>(deporteEncontrado, HttpStatus.OK);
    }

    @GetMapping(path="/findSportsPersons")
    public String sportsAndPersons(){
        List<DTOPersonaDeporte> deportes = crearPersonasDeportistasDTO();
        String json = new Gson().toJson(deportes);
        return json;
    }

    private List<DTOPersonaDeporte> crearPersonasDeportistasDTO() {

        Deporte futbol = new Deporte("Futbol","Avanzado");
        Deporte natacion = new Deporte("Natacion","Avanzado");
        Deporte basquet = new Deporte("Basquet","Avanzado");

        Persona persona_uno = new Persona("Ignacio","Tornati",23,futbol);
        Persona persona_dos = new Persona("Agustin","Tornati",23,natacion);
        Persona persona_tres = new Persona("Matias","Tornati",23,basquet);

        List<DTOPersonaDeporte> dtos= new ArrayList<>();
        dtos.add(new DTOPersonaDeporte(persona_uno.getNombre(),persona_uno.getApellido(),persona_uno.getDeporte().getName(),persona_uno.getEdad()));
        dtos.add(new DTOPersonaDeporte(persona_dos.getNombre(),persona_dos.getApellido(),persona_dos.getDeporte().getName(),persona_dos.getEdad()));
        dtos.add(new DTOPersonaDeporte(persona_tres.getNombre(),persona_tres.getApellido(),persona_tres.getDeporte().getName(),persona_tres.getEdad()));

        return dtos;
    }


    public List<Deporte> crearDeportes(){
        List<Deporte> deporte = new ArrayList<>();
        deporte.add(new Deporte("Futbol","Avanzado"));
        deporte.add(new Deporte("Tenis","Avanzado"));
        deporte.add(new Deporte("Natacion","Avanzado"));
        deporte.add(new Deporte("Beisbol","Avanzado"));



        return deporte;
    }

}
