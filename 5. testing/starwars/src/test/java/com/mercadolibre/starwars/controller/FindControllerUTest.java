package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerUTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void shoulsFindLuke() {
        String query = "Luke";
        List<CharacterDTO> expectedCharacterList = List.of(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));

        when(findService.find(anyString())).thenReturn(expectedCharacterList);
        List<CharacterDTO> foundCharacterList = findController.find(query);

        assertEquals(expectedCharacterList, foundCharacterList);
    }

    @Test
    @DisplayName("Check service handshake call in find")
    void find() {
        // Arrange
        CharacterDTO char1 = new CharacterDTO();
        CharacterDTO char2 = new CharacterDTO();
        List<CharacterDTO> expectedCharacters = List.of(char1, char2);
        when(findService.find(anyString())).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> retrievedCharacters = findController.find("Lucas");

        // Assert
        verify(findService, atLeastOnce()).find(anyString());
        assertEquals(expectedCharacters, retrievedCharacters);
    }
}
