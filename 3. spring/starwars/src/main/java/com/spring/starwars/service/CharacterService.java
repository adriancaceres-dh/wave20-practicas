package com.spring.starwars.service;

import com.spring.starwars.dto.CharacterDTO;
import com.spring.starwars.model.Character;
import com.spring.starwars.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    public CharacterRepository characterRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<CharacterDTO> characterByName(String name) {
        List<Character> characters = characterRepository.characters.stream().filter(c -> c.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
        return characters.stream().map(c -> mapper.map(c, CharacterDTO.class)).collect(Collectors.toList());
    }
}
