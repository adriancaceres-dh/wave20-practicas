package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;
    @Test
    @DisplayName("Encuentra un personaje por una porción del nombre")
    void findOKTest() {
        //arrange
        String nameExpected = "Luke Skywalker";
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setSpecies("Human");
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(List.of(characterDTO));

        //act
        CharacterDTO actual = findService.find("Luke").get(0);

        //assert
        assertEquals(nameExpected, characterDTO.getName());
    }
}