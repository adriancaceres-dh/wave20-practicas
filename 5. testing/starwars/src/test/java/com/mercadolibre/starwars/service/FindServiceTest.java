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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    void find() {
        //arrange
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Wilhuff Tarkin");
        characterDTO.setHeight(180);
        characterDTO.setMass(77);
        characterDTO.setHair_color("auburn, grey");
        List<CharacterDTO> characterDTOListExpected = new ArrayList<>();
        characterDTOListExpected.add(characterDTO);
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(characterDTOListExpected);
        //act
        List<CharacterDTO> characterDTOListActual = findService.find(anyString());
        //assert
        assertEquals(characterDTOListExpected.get(0).getName(), characterDTOListActual.get(0).getName());
        assertEquals(characterDTOListExpected.get(0).getHeight(), characterDTOListActual.get(0).getHeight());
        assertEquals(characterDTOListExpected.get(0).getHair_color(), characterDTOListActual.get(0).getHair_color());
        assertEquals(characterDTOListExpected.get(0).getMass(), characterDTOListActual.get(0).getMass());
    }
}