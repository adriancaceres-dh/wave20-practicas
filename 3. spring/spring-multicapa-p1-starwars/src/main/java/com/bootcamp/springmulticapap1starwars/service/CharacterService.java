package com.bootcamp.springmulticapap1starwars.service;

import com.bootcamp.springmulticapap1starwars.dto.response.CharacterResponseDTO;
import com.bootcamp.springmulticapap1starwars.model.Character;
import com.bootcamp.springmulticapap1starwars.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final ModelMapper mapper;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public List<CharacterResponseDTO> filterBy(String name) {
        List<Character> characters = characterRepository.filterBy(name);
        List<CharacterResponseDTO> charactersResponseDTO = new ArrayList<>();
        characters.forEach(c -> charactersResponseDTO.add(mapper.map(c, CharacterResponseDTO.class)));
        return charactersResponseDTO;
    }
}
