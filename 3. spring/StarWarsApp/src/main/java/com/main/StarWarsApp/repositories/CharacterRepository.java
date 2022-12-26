package com.main.StarWarsApp.repositories;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.StarWarsApp.dtos.CharacterDTO;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
@Data
public class CharacterRepository {

    List<CharacterDTO> database;

    public CharacterRepository() {
        this.database = loadDataBase();
    }

    public List<CharacterDTO> findAll(){
        return database;
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<CharacterDTO> findAny(String name) {
       return database.stream().filter(p->p.getName().toLowerCase(Locale.ROOT).contains(name)).collect(Collectors.toList());
    }
}
