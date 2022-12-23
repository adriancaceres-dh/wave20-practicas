package com.bootcamp.deportes.service;

import com.bootcamp.deportes.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteService {

    List<Deporte> listaDeportes;

    public DeporteService() {
        listaDeportes = new ArrayList<>();
        listaDeportes.add(new Deporte(1,"Futbol","Principiante"));
        listaDeportes.add(new Deporte(2,"Boxeo","Intermedio"));
        listaDeportes.add(new Deporte(3,"Natacion","Avanzado"));
    }

    public List<Deporte> todosLosDeportes(){
        return listaDeportes;
    }

    public String nivelDeDeporte(String nombreDeporte){
        return listaDeportes.stream()
                .filter(d -> d.getNombre().equals(nombreDeporte))
                .findAny()
                .map(Deporte::getNivel).orElse("Deporte no encontrado");
        //return listaDeportes.stream().filter(d -> d.getNombre().equals(nombreDeporte)).map(Deporte::getNivel).collect(Collectors.joining());
    }




}
