package com.Arquitectura.MulticapaP1VIVO.StarWars.Repository;

import com.Arquitectura.MulticapaP1VIVO.StarWars.Dto.PersonajeDto;
import com.Arquitectura.MulticapaP1VIVO.StarWars.Entity.PersonajeModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepository {

    List<PersonajeDto> personajes;

    public PersonajeRepository() {
        this.personajes = this.loadDataBase();
    }

    public List<PersonajeDto> getPersonajes() {
        return personajes;
    }

    private List<PersonajeDto> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDto>> typeRef = new TypeReference<>() {};
        List<PersonajeDto> personajesDto = null;
        try {
            personajesDto = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajesDto;
    }
}
