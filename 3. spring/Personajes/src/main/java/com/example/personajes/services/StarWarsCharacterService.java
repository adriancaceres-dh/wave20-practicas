package com.example.personajes.services;

import com.example.personajes.dtos.CharacterDto;
import com.example.personajes.repositories.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StarWarsCharacterService implements IStarWarsCharacterService{
    private final ICharacterRepository _repo;
    public StarWarsCharacterService(ICharacterRepository characterRepository) {
        _repo = characterRepository;
    }

    public Collection<CharacterDto> findByName(String name){
        Collection<CharacterDto> result = _repo.findByName(name).stream()
                .map(ch -> new CharacterDto(ch.getName(), ch.getHeight(),ch.getMass(),ch.getGender(),ch.getHomeworld(),ch.getSpecies())).toList();
        return result;
    }

}
