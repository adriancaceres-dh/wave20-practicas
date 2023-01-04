package com.example.demoarquitectura.repository;

import com.example.demoarquitectura.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataRepository {

    private final List<CharacterDTO> database;

    public DataRepository(List<CharacterDTO> database) {
        this.database = loadDataBase();
    }

    public List<CharacterDTO> nameStarWars(String name) {
        return database.stream().filter(characterDTO -> characterDTO.getName().contains(name)).collect(Collectors.toList());
    }

    private boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {
        };
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


}
