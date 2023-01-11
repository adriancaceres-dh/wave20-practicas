package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    private FindService mockFindService;
    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("Find list of characters")
    void find() {
        //arrange
        CharacterDTO char1 = new CharacterDTO();
        CharacterDTO char2 = new CharacterDTO();
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(char1);
        characters.add(char2);
        when(mockFindService.find("Lucas")).thenReturn(characters);
        //act
        List<CharacterDTO> retrievedCharacters = findController.find("Lucas");
        //assert
        assertEquals(characters, retrievedCharacters);
    }
}