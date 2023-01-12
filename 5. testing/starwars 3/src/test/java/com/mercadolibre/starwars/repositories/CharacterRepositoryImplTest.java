package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
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
class CharacterRepositoryImplTest {

    @Mock
    List<CharacterDTO> database;

    @InjectMocks
    CharacterRepositoryImpl characterRepository;




    @Test
    void findAllByNameContains() {
        //Arrange
        String query = "Skywalker";

        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setSpecies("Human");

        CharacterDTO anakin = new CharacterDTO();
        anakin.setName("Anakin Skywalker");
        anakin.setSpecies("Human");

        CharacterDTO shmi = new CharacterDTO();
        shmi.setName("Shmi Skywalker");
        //mockCharacterList = Arrays.asList(luke, anakin);
        List<CharacterDTO> expected = Arrays.asList(luke,anakin,shmi);
        //when(database.stream()).thenReturn(expected.stream());

        //Act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains(query);

        //Assert
        assertEquals(expected.get(2).getName(), actual.get(2).getName());
        assertEquals(expected.size(), actual.size());
    }
}