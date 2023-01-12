package com.mercadolibre.starwars.service.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository; //interfaz

    @InjectMocks
    private FindService findService; //Implementacion

    @Test
    void findServiceTest(){
        //Arrange
        String name = "Darth";
        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName(name);
        List<CharacterDTO> dtoList = Arrays.asList(expectedCharacter);
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(dtoList);

        //Act
        List<CharacterDTO> findCharacters = findService.find(name);

        //Assert
        Assertions.assertEquals(dtoList,findCharacters);

    }

}
