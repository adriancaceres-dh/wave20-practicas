package com.mercadolibre.starwars;

import com.mercadolibre.starwars.controller.FindController;
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
class FindControllerTest {

    @Mock
    private FindService findService;
    @InjectMocks
    private FindController findController;

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
        verify(findService, atLeast(1)).find(anyString());
        assertEquals(expectedCharacters, retrievedCharacters);
    }
}
