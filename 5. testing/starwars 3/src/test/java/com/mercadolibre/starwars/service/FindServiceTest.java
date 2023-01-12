package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    void find() {
        String query = "Skywalker";

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setSpecies("Human");

        CharacterDTO anakin = new CharacterDTO();
        anakin.setName("Anakin Skywalker");
        anakin.setSpecies("Human");

        List<CharacterDTO> expected = Arrays.asList(luke,anakin);
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        //Act
        List<CharacterDTO> actual = findService.find(query);

        //Assert
        assertEquals(expected, actual);
    }
}