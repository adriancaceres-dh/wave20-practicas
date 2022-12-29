package com.ArquitecturaMulticapa.arquitecturaMulticapa.repository;

import com.ArquitecturaMulticapa.arquitecturaMulticapa.dto.CharacterDto;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterDto> findAllByNameContains(String query);
}
