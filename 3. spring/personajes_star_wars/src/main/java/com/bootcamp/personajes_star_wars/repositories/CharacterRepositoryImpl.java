package com.bootcamp.personajes_star_wars.repositories;

import com.bootcamp.personajes_star_wars.dto.CharacterDTO;
import com.bootcamp.personajes_star_wars.models.Character;
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
public class CharacterRepositoryImpl implements ICharacterRepository{

    private final List<Character> characters;

    public CharacterRepositoryImpl(){
        this.characters = loadDataBase();
    }

    public List<Character> findCharacters(String word){
        return characters.stream()
                .filter(c -> c.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Character> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

}
