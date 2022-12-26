package com.example.ejercicio_personajes_star_wars.service;

import com.example.ejercicio_personajes_star_wars.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaService implements IPersonaService{

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaService> findAll(){
        Li
    }
}
