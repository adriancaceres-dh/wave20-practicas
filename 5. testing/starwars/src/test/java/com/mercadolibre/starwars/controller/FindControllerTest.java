package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService mockFindService;

    @InjectMocks
    FindController findController;
    @Test
    @DisplayName("US-0001 camino feliz :)")
    void shouldFindAllCharactersThatMatch() {
        //Arrange
        String query = "Skywalker";

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setSpecies("Human");

        CharacterDTO anakin = new CharacterDTO();
        anakin.setName("Anakin Skywalker");
        anakin.setSpecies("Human");

        List<CharacterDTO> expected = Arrays.asList(luke,anakin);
        when(mockFindService.find(query)).thenReturn(expected);

        //Act
        List<CharacterDTO> actual = findController.find(query);

        //Assert
        assertEquals(expected, actual);
    }
}