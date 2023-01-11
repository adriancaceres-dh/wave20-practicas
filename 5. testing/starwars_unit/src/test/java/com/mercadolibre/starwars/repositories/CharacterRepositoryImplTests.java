package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryImplTests {

    CharacterRepository characterRepository;

    public CharacterRepositoryImplTests() {
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsSize() {
        // arrange
        String query = "Darth";
        int expected = 2;
        // act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains(query);
        // assert
        assertEquals(expected, actual.size());
    }

    @Test
    void findAllByNameContainsEmpty() {
        // arrange
        String query = "Pedro";
        int expected = 0;
        // act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains(query);
        // assert
        assertEquals(expected, actual.size());
    }
}
