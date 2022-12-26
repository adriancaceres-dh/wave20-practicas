package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.CharacterDtoResponse;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterServiceImpl implements ICharacterService{

    ModelMapper mapper = new ModelMapper();

    public CharacterServiceImpl() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    private CharacterRepository characterRepository = new CharacterRepository();
    @Override
    public List<CharacterDtoResponse> charactersThatMatch(String query) {
        return characterRepository.findAllByNameContains(query).stream()
                .map(c -> mapper.map(c,CharacterDtoResponse.class))
                .collect(Collectors.toList());
    }
}
