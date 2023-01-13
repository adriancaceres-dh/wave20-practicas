package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    void findCharacterOk(){
        //arrange
        String name = "luke";
        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName(name);
        List<CharacterDTO> dtoList = Arrays.asList(expectedCharacter);
        when(findService.find(anyString())).thenReturn(dtoList);

        //Act
        List<CharacterDTO> actualCharacter =  findController.find(name);

        //Assert
        Assertions.assertEquals(dtoList, actualCharacter);
    }


}