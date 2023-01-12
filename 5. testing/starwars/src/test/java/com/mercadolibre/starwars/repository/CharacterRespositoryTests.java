package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRespositoryTests {
    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    @DisplayName("Find All By Contains Name. Encuentra uno")
    public void findAllByContainsNameFoundOneTest(){
        // arrange
        CharacterDTO expectedCharacterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        List<CharacterDTO> expected = List.of(expectedCharacterDTO);

        // act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke Skywalker");

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Find All By Contains Name. Encuentra mas de uno")
    public void findAllByContainsNameFoundMoreThanOneTest(){
        // arrange
        CharacterDTO expectedCharacterDTO = new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO expectedCharacterDTO2 = new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80);

        List<CharacterDTO> expected = List.of(expectedCharacterDTO, expectedCharacterDTO2);

        // act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Darth");

        // assert
        Assertions.assertEquals(expected, result);
    }
    @Test
    @DisplayName("Find All By Contains Name. No encuentra ninguno")
    public void findAllByContainsNameEmptyTest(){
        // arrange
        List<CharacterDTO> expected = new ArrayList<>();
        // act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("DarthLuke");

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Load data Test")
    public void loadDataTest(){
        // act
        characterRepository = new CharacterRepositoryImpl();

        // assert
        Assertions.assertNotNull(characterRepository);
    }

}
