package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
class FindServiceTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findCharacter(){
        //Arrange
        String name = "luke";
        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName("luke");
        List<CharacterDTO> expectedList = Arrays.asList(expectedCharacter);
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(expectedList);

        //Act
        List<CharacterDTO> actual = findService.find(name);
        //Assert
        Assertions.assertEquals(expectedList, actual);
    }

}