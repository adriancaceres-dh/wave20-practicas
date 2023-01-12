package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacterRepositoryImplTest {


    @InjectMocks
    CharacterRepositoryImpl repo;

    @Test
    void findAllByNameContains() {
        //Arrange
       /* CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setSpecies("Human");
        CharacterDTO anakin = new CharacterDTO();
        anakin.setName("Anakin Skywalker");
        anakin.setSpecies("Human");
        CharacterDTO shim = new CharacterDTO();
        anakin.setName("Shmi Skywalker");
        anakin.setSpecies("Human");
        List<CharacterDTO> expected = Arrays.asList(luke,anakin, shim);*/
        //Act
        List<CharacterDTO> actual = repo.findAllByNameContains("Skywalker");
        //Assert
        assertEquals(3,actual.size());

    }
}