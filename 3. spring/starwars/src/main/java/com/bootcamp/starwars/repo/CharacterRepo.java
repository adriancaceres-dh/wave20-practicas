package com.bootcamp.starwars.repo;

import com.bootcamp.starwars.dto.CharacterDTO;
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
public class CharacterRepo implements ICharacterRepo{

    private final List<CharacterDTO> database;

    public CharacterRepo (List<CharacterDTO> database) {
        this.database = loadDatabase();
    }
    @Override
    public List<CharacterDTO> findAllCharacters(String search) {
        return database.stream()
                .filter(characterDTO -> containsString(characterDTO, search))
                .collect(Collectors.toList());
    }

    private boolean containsString(CharacterDTO character, String search) {
        return character.getName().toUpperCase().contains(search.toUpperCase());
    }

    private List<CharacterDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
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
}
