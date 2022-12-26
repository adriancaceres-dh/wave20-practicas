
package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.CharacterModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bootcamp.starwars.dto.response.CharacterDtoResponse;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

    @Repository
    public class CharacterRepository {
        private final List<CharacterModel> database;

        public CharacterRepository() {
            this.database = loadDataBase();
        }


        public List<CharacterModel> findAllByNameContains(String query) {
            return database.stream()
                    .filter(characterDTO -> matchWith(query, characterDTO))
                    .collect(Collectors.toList());
        }

        private boolean matchWith(String query, CharacterModel character) {
            return character.getName().toUpperCase().contains(query.toUpperCase());
        }


        private List<CharacterModel> loadDataBase() {
            File file = null;
            try {
                file = ResourceUtils.getFile("/Users/audiaz/Documents/wave20-practicas/3. spring/starwars/src/main/resources/3. starwars.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<CharacterModel>> typeRef = new TypeReference<>() {};
            List<CharacterModel> characters = null;
            try {
                characters = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return characters;
        }
}
