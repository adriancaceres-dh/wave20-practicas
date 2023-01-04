package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;

import java.util.List;

public interface DeportistasRepositoryInterface {

    public List<Deporte> todosLosDeportes();
    public List<Persona> todasLasPersonas();


}
