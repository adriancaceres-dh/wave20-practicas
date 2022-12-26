package com.starwars.StarWars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.StarWars.dto.PersonajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepositoryImp implements StarWarsRepository{

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public List<PersonajeDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<>() {
        };
        List<PersonajeDTO> personajeDTOList = null;
        try {
            personajeDTOList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajeDTOList;
    }
}
