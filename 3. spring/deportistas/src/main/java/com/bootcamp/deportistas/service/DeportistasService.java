package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeportistasService {

    private Map<Persona, Deporte> deportistas;

    public DeportistasService(){


    }

    public List<String> todosLosDeportes () {

        List<String> listaDeportes = new ArrayList<>();
        //deportes.forEach( (k,v) -> listaDeportes.add(k));
        listaDeportes.addAll(deportistas.forEach((k,v)->v.getNombre());
        listaDeportes.stream().distinct().
        return listaDeportes;
    }



}
