package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;



public class FindServiceTests {
    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    FindService findService = new FindService(characterRepository);

    @Test
    @DisplayName("Find service, encuentra uno")
    public void findTestOK(){
        // arrange
        CharacterDTO expectedCharacterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        List<CharacterDTO> expected = List.of(expectedCharacterDTO);

        //act
        List<CharacterDTO> result = findService.find("Luke");
        // assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Find Service, no encuentra ninguno")
    public void findTestEmptyOK(){
        // arrange
        List<CharacterDTO> expected = new ArrayList<>();

        //act
        List<CharacterDTO> result = findService.find("Lukes");
        // assert
        Assertions.assertEquals(expected,result);
    }

}
