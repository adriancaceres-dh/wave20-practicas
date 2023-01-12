package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.UtilTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {

    @InjectMocks
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContainsOk(){
        //Arrange
        List<CharacterDTO> expectedCharacters = UtilTest.getCharacters();

        //Act
        List<CharacterDTO> actualCharacters = characterRepository.findAllByNameContains("Darth");

        //Assert
        Assertions.assertEquals(expectedCharacters, actualCharacters);
    }
}
