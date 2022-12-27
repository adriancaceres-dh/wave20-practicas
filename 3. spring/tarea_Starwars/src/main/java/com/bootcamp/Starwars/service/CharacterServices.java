package com.bootcamp.Starwars.service;

import com.bootcamp.Starwars.DTO.CharacterDTO;
import com.bootcamp.Starwars.model.Character;
import com.bootcamp.Starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServices implements ICharacterServices {

    @Autowired
    private CharacterRepository characterRepository;

  //  public CharacterServices (){characterRepository = new CharacterRepository();}

    public List<CharacterDTO> getCharacters(){
        List<Character> characterList =  characterRepository.getCharacters();
        return characterList.stream().map(c ->
                CharacterDTO.builder()
                        .name(c.getName())
                        .gender(c.getGender())
                        .homeworld(c.getHomeworld())
                        .species(c.getSpecies())
                        .height(c.getHeight())
                        .mass(c.getMass())
                        .build())
                .collect(Collectors.toList());
    }

    public List<CharacterDTO> getCharacters(String characterName){
        System.out.println(characterName);
        List<Character> characterList =  characterRepository.getCharacters();
        return characterList.stream().filter(c -> c.getName().toUpperCase().contains(characterName.toUpperCase())).map(c ->
                        CharacterDTO.builder()
                                .name(c.getName())
                                .gender(c.getGender())
                                .homeworld(c.getHomeworld())
                                .species(c.getSpecies())
                                .height(c.getHeight())
                                .mass(c.getMass())
                                .build())
                .collect(Collectors.toList());
    }
}
