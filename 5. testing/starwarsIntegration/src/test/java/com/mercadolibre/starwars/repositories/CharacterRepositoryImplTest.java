package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    private static CharacterRepositoryImpl characterRepository;

    @BeforeAll
    static void initAll() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Find all by an existing name")
    void findAllByNameContains() {
        //assert
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("Darth");
        //act
        assertNotNull(characters);
        assertEquals(2, characters.size());
    }

    @Test
    @DisplayName("Find all by non existent name")
    void findAllByNameContainsWithAnNonExistentName() {
        //assert
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("THIS-DOES-NOT-EXIST");
        //act
        assertNotNull(characters);
        assertEquals(0, characters.size());
    }
}