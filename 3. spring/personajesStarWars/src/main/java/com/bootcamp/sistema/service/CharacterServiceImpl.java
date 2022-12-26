package com.bootcamp.sistema.service;

import com.bootcamp.sistema.dto.CharacterDTO;
import com.bootcamp.sistema.model.CharacterEntity;
import com.bootcamp.sistema.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements ICharacterService{
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> findAllByName(String name) {
        return characterRepository.getAll().stream()
                .filter(character -> character.getName().contains(name))
                .map(character -> new CharacterDTO(character.getName(), character.getGender(), character.getHomeworld(), character.getSpecies(), character.getHeight(), character.getMass()))
                .collect(Collectors.toList());
    }


}
