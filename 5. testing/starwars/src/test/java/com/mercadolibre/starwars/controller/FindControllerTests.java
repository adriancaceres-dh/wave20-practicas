package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findOk() {
        // arrange
        String query = "Luke";
        List<CharacterDTO> expected = List.of(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        when(findService.find(query)).thenReturn(expected);
        // act
        List<CharacterDTO> actual = findController.find(query);
        // assert
        verify(findService, atLeastOnce()).find(query);
        assertEquals(expected, actual);
    }

    @Test
    void findEmpty() {
        // arrange
        String query = "Pedro";
        List<CharacterDTO> expected = List.of();
        when(findService.find(query)).thenReturn(expected);
        // act
        List<CharacterDTO> actual = findController.find(query);
        // assert
        verify(findService, atLeastOnce()).find(query);
        assertTrue(actual.isEmpty());
    }
}
