package com.example.personajes.services;

import com.example.personajes.dtos.CharacterDto;
import com.example.personajes.entities.StarWarsCharacter;

import java.util.Collection;

public interface IStarWarsCharacterService {
    Collection<CharacterDto> findByName(String name);
}
