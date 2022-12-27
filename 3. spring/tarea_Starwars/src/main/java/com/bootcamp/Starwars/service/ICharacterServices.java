package com.bootcamp.Starwars.service;

import com.bootcamp.Starwars.DTO.CharacterDTO;

import java.util.List;

public interface ICharacterServices {
    List<CharacterDTO> getCharacters();
    List<CharacterDTO> getCharacters(String characterName);
}
