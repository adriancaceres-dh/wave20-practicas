package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Persona;

import java.util.List;

public interface IPersonaRepository {
    boolean addPersona(Persona persona);
    List<Persona> getPersonas();
}
