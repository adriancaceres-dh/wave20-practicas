package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {
    private final CharacterRepositoryImpl characterRepository;

    public CharacterRepositoryImplTest(){
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void testFindAllByNameContains(){

        //Arrange
        String query = "Darth";

        String expected = "Darth Maul";

        //Action
        List<CharacterDTO> characterFound = characterRepository.findAllByNameContains(query);

        //Asserts
        assertEquals(expected,characterFound.get(1).getName());
        assertTrue(characterFound.get(0).getName().contains(query));
    }

}