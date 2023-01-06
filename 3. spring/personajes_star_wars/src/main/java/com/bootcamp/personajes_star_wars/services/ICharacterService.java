package com.bootcamp.personajes_star_wars.services;

import com.bootcamp.personajes_star_wars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    List<CharacterDTO> find(String word);
}
