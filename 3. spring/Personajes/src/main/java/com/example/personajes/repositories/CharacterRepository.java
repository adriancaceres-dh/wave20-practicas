package com.example.personajes.repositories;

import com.example.personajes.entities.StarWarsCharacter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private final List<StarWarsCharacter> db;

    public CharacterRepository(){
        db = loadDataBase();
    }

    public Collection<StarWarsCharacter> findByName(String name){
        return db.stream().filter(c -> c.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    private List<StarWarsCharacter> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:3. starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarsCharacter>> typeRef = new TypeReference<>() {};
        List<StarWarsCharacter> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characters;
    }

}
