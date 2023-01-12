package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.UtilTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findOk(){
        //Arrange
        List<CharacterDTO> expectedCharacters = UtilTest.getCharacters();
        when(findService.find("Darth")).thenReturn(expectedCharacters);

        //Act
        List<CharacterDTO> actualCharacters = findController.find("Darth");

        //Assert
        verify(findService, atLeast(1)).find("Darth");
        Assertions.assertEquals(expectedCharacters, actualCharacters);
    }
}
