package com.starwars.starwarsCharacters.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwarsCharacters.models.StarwarsCharacters;

@Repository
public class StarwarsRepository {

    
    private  List<StarwarsCharacters> loadDatabase() {
        
        File file = null;
        try {
          file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarwarsCharacters>> typeRef = new TypeReference<>() {};
        List<StarwarsCharacters> characters = null;
        try {
          characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println("Hubo una excepción.");
          e.printStackTrace();
        }
        System.out.println("Hubo?");
        return characters;
    }
    
    public List<StarwarsCharacters> findCharacters (String name){
 // we gonna search into our false database to find the information of a character.
List<StarwarsCharacters> database = loadDatabase();
System.out.println("hola che");
System.out.println("habra encontrado esto?");
return database.stream().filter(c-> c.getName().contains(name)).collect(Collectors.toList());
        
    }
}
