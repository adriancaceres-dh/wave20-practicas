package com.example.personajes.repositories;

import com.example.personajes.entities.StarWarsCharacter;

import java.util.Collection;

public interface ICharacterRepository {
    Collection<StarWarsCharacter> findByName(String name);

}
