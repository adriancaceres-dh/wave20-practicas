package com.ArquitecturaMulticapa.arquitecturaMulticapa.repository;

import com.ArquitecturaMulticapa.arquitecturaMulticapa.Models.Character;
import com.ArquitecturaMulticapa.arquitecturaMulticapa.dto.CharacterDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@Repository
public class CharacterRepository implements ICharacterRepository{

    private final List<CharacterDto> database;
    private final ModelMapper modelMapper;

    public CharacterRepository() {
        modelMapper= new ModelMapper();
        this.database = loadDataBase();
    }

    @Override
    public List<CharacterDto> findAllByNameContains(String query) {
        return database.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, CharacterDto characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }


    private List<CharacterDto> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("/Users/LWALSH/Documents/projects/arquitecturaMulticapa/src/main/resources/3. starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {
        };
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return characters.stream().map(c->modelMapper.map(c, CharacterDto.class)).collect(Collectors.toList());
    }


}
