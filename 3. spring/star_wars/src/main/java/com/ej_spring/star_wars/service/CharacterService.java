package com.ej_spring.star_wars.service;

import com.ej_spring.star_wars.dto.CharacterDto;
import com.ej_spring.star_wars.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    public CharacterRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public CharacterService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public List<CharacterDto> charactersByName(String name) {
        return this.repository
                .characters()
                .stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .map(p-> mapper.map(p,CharacterDto.class))
                .collect(Collectors.toList());
    }
}
