package com.mercadolibre.starwars.controller.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FindServiceTestSinMock {
    @Autowired
    FindService findService;

    @Test
    @DisplayName("US0001-Camino Feliz ")
    void findTestOK(){
        //ARRANGE
        String query = "luke";
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male", "Tatooine","Human",172,77));
        //ACT
        List<CharacterDTO> result = findService.find(query);
        //ASSERT
        Assertions.assertEquals(expected,result);
    }
}
