package com.bootcamp.sistema.service;

import com.bootcamp.sistema.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> findAllByName(String query);
}
