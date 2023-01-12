package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterRepoTest {

  private final CharacterRepository characterRepository = new CharacterRepositoryImpl();
  @Test
  void testFindAllByNameContains() {
    //arrange
    int expectedSize = 2;
    //act
    List<CharacterDTO> result = characterRepository.findAllByNameContains("Darth");
    //assert
    assertEquals(expectedSize, result.size());
  }

  @Test
  void testFindAllByNameContains2() {
    //arrange
    int expectedSize = 0;
    //act
    List<CharacterDTO> result = characterRepository.findAllByNameContains("Darht");
    //assert
    assertEquals(expectedSize, result.size());
  }

}
