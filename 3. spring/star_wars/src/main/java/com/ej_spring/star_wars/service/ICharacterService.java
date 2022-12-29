package com.ej_spring.star_wars.service;

import com.ej_spring.star_wars.dto.CharacterDto;

import java.util.List;

public interface ICharacterService {

    public List<CharacterDto> charactersByName(String name);
}
