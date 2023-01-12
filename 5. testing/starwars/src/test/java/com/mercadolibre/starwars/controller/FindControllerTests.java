package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FindControllerTests {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("Metodo find del controller. Encuentra un personaje")
    public void findTest(){
        // arrange
        String query = "Luke";

        // act
        findController.find(query);

        // assert
        verify(findService,atLeastOnce()).find(query);
    }
    @Test
    @DisplayName("Metodo find del controller. No encuentra un personaje")
    public void findEmptyTest(){
        // arrange
        String query = "Luke";
        when(findService.find(anyString())).thenReturn(Collections.emptyList());

        // act
        List<CharacterDTO> result = findController.find(query);

        // assert
        Assertions.assertEquals(Collections.emptyList(), result);
    }
}
