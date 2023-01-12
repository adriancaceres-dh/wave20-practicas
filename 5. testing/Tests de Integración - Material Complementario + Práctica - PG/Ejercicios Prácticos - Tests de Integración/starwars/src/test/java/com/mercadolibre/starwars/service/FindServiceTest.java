package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findOk() {
        //Arrange
        List<CharacterDTO> expectedCharacters = UtilTest.getCharacters();
        when(characterRepository.findAllByNameContains("Darth")).thenReturn(expectedCharacters);

        //Act
        List<CharacterDTO> actualCharacters = findService.find("Darth");

        //Assert
        verify(characterRepository, atLeast(1)).findAllByNameContains("Darth");
        Assertions.assertEquals(expectedCharacters, actualCharacters);
    }
}
