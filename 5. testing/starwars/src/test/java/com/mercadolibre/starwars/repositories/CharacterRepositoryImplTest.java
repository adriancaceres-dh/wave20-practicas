package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {
    private CharacterRepositoryImpl characterRepository;

    public CharacterRepositoryImplTest() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsOk() {
        //arrange
        String name = "Luke";
        String nameComp = "Luke Skywalker";
        //act
        List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains(name);
        //assert
        assertEquals(nameComp, characterDTOList.get(0).getName());
    }
}