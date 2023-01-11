package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
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
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    void findTest() {
        // Arrange
        CharacterDTO char1 = new CharacterDTO();
        CharacterDTO char2 = new CharacterDTO();
        List<CharacterDTO> expectedCharacters = List.of(char1, char2);
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> charactersFound = findService.find("Character Name");

        // Assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(anyString());
        assertEquals(expectedCharacters, charactersFound);
    }
}
