package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl mockCharacterRepository;
    @InjectMocks
    FindService findService;


    @Test
    void testFind(){
        //Arrange
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("human");
        List<CharacterDTO> expectedList = List.of(characterDTO);

        //Act
        when(mockCharacterRepository.findAllByNameContains(query)).thenReturn(expectedList);

        //Assert
        Assertions.assertEquals(expectedList,findService.find(query));

    }

}
