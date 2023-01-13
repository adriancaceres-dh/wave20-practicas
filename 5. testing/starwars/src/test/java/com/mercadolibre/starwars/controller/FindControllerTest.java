package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
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
    void findOk() {
        //arrange
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Wilhuff Tarkin");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("64BBY");
        characterDTO.setGender("male");
        List<CharacterDTO> characterDTOListExpected = new ArrayList<>();
        characterDTOListExpected.add(characterDTO);
        when(findService.find(anyString())).thenReturn(characterDTOListExpected);
        //act
        List<CharacterDTO> characterDTOListActual = findController.find(anyString());
        //assert
        assertEquals(characterDTOListExpected.get(0).getName(), characterDTOListActual.get(0).getName());
        assertEquals(characterDTOListExpected.get(0).getSkin_color(), characterDTOListActual.get(0).getSkin_color());
        assertEquals(characterDTOListExpected.get(0).getEye_color(), characterDTOListActual.get(0).getEye_color());
        assertEquals(characterDTOListExpected.get(0).getBirth_year(), characterDTOListActual.get(0).getBirth_year());
        assertEquals(characterDTOListExpected.get(0).getGender(), characterDTOListActual.get(0).getGender());
    }
}