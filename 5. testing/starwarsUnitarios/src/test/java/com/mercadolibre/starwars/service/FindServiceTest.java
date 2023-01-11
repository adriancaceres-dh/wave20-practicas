package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    private CharacterRepository mockCharacterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    void find() {
        //arrange
        CharacterDTO char1 = new CharacterDTO();
        CharacterDTO char2 = new CharacterDTO();
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(char1);
        characters.add(char2);
        when(mockCharacterRepository.findAllByNameContains("Maik")).thenReturn(characters);
        //act
        List<CharacterDTO> charactersFound = findService.find("Maik");
        //assert
        assertEquals(characters, charactersFound);
    }
}