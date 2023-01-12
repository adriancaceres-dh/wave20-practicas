package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);
}
