package com.bootcamp.starwars.Star.wars.service;

import com.bootcamp.starwars.Star.wars.dto.CharacterDTO;
import com.bootcamp.starwars.Star.wars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    public static List<CharacterDTO> findCharacterWithName(String name, List<CharacterDTO> characters){
        List<CharacterDTO> finalCharacters = characters.getPersonajeRepository().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println(finalCharacters);
        return finalCharacters;
    }
}
