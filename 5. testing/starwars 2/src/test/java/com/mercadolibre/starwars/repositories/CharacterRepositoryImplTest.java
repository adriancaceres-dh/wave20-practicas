package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CharacterRepositoryImplTest {

    @InjectMocks
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContainsOk(){
        //Arrange
        String name = "Luke";
        CharacterDTO expectedCharacter = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        List<CharacterDTO> expectedList = Arrays.asList(expectedCharacter);

        //Act
        List<CharacterDTO> actualCharacter = characterRepository.findAllByNameContains(name);

        // Assert
        Assertions.assertEquals(expectedList, actualCharacter);
    }
}