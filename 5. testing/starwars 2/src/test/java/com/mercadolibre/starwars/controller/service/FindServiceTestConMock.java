package com.mercadolibre.starwars.controller.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTestConMock {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("US0001-Camino Feliz")
    void findTestOK(){
        //ARRANGE
        String query = "Luke";
        List<CharacterDTO> listMock = new ArrayList<>();
        listMock.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male", "Tatooine","Human",172,77));
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male", "Tatooine","Human",172,77));
        when(characterRepository.findAllByNameContains(query)).thenReturn(listMock);
        //ACT
        List<CharacterDTO> result = findService.find(query);
        //ASSERT
        Assertions.assertEquals(expected,result);
    }

}
