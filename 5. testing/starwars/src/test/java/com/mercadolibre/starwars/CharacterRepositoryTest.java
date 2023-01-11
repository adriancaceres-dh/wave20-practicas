package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {
    private static CharacterRepositoryImpl characterRepository;

    @BeforeAll
    static void init() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Search existing character name")
    public void findAllByNameContainsTest() {
        // Arrange
        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("Lars");
        // Assert
        assertNotNull(characters);
        assertEquals(3, characters.size());
    }

    @Test
    @DisplayName("Search existing character name in all caps")
    public void findAllByNameContainsAllCapsTest() {
        // Arrange
        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("LUKE");
        // Assert
        assertNotNull(characters);
        assertEquals(1, characters.size());
    }

    @Test
    @DisplayName("Search empty String returns whole database")
    public void findAllByNameContainsAllDbTest() {
        // Arrange
        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("");
        // Assert
        assertNotNull(characters);
        assertEquals(87, characters.size());
    }

    @Test
    @DisplayName("Search non-existing character name")
    public void findAllByNameContainsEmptyTest() {
        // Arrange
        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("no character matches");
        // Assert
        assertNotNull(characters);
        assertEquals(0, characters.size());
    }
}
