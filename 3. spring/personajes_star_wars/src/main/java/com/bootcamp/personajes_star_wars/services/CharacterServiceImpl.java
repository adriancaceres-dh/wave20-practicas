package com.bootcamp.personajes_star_wars.services;

import com.bootcamp.personajes_star_wars.dto.CharacterDTO;
import com.bootcamp.personajes_star_wars.models.Character;
import com.bootcamp.personajes_star_wars.repositories.ICharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    private ICharacterRepository characterRepository;

    public List<CharacterDTO> find(String word){
        List<Character> character = characterRepository.findCharacters(word);
        ModelMapper mapper = new ModelMapper();
        return character.stream().map(c -> mapper.map(c, CharacterDTO.class)).collect(Collectors.toList());
    }
}
