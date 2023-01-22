package com.starwars.starwarsCharacters.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.starwarsCharacters.dtoresponse.CharactersDtoResponse;
import com.starwars.starwarsCharacters.models.StarwarsCharacters;
import com.starwars.starwarsCharacters.repository.StarwarsRepository;

@Service
public class StarwarsService {

    @Autowired
    private StarwarsRepository starwarsRepository;

    @Autowired
    private ModelMapper mapper;

    public List<CharactersDtoResponse> findCharacters(String name) {
        List<StarwarsCharacters> allCharacters = starwarsRepository.findCharacters(name); // get all characters.
        List<CharactersDtoResponse> filteredCharacters = new ArrayList<>();
        allCharacters.forEach(c -> filteredCharacters.add(mapper.map(c, CharactersDtoResponse.class)));
        return filteredCharacters;
    }
}
