package com.spring.starwars.service;

import com.spring.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    public List<CharacterDTO> characterByName(String name);
}
