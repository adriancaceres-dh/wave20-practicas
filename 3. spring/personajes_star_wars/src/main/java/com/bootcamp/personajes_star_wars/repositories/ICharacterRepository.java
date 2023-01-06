package com.bootcamp.personajes_star_wars.repositories;

import com.bootcamp.personajes_star_wars.dto.CharacterDTO;
import com.bootcamp.personajes_star_wars.models.Character;

import java.util.List;

public interface ICharacterRepository {

    public List<Character> findCharacters(String word);
}
