package com.bootcamp._multicapa_star_wars.repository;

import com.bootcamp._multicapa_star_wars.dto.PersonajeDTO;
import com.bootcamp._multicapa_star_wars.model.PersonajeEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    private List<PersonajeEntity> personajeRepositorio;

    public PersonajeRepository(){this.personajeRepositorio=loadDataBase();}

    public List<PersonajeEntity> getAll(){
        return personajeRepositorio;
    }

    public boolean addAll(List<PersonajeEntity> personajes){
        return personajeRepositorio.addAll(personajes);
    }

    public boolean add (PersonajeEntity personaje){
        return personajeRepositorio.add(personaje);
    }

    private List<PersonajeEntity> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeEntity>> typeRef = new TypeReference<>() {};
        List<PersonajeEntity> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

}
