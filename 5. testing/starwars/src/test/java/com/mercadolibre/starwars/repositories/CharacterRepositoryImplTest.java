package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository;

    @Autowired
    public CharacterRepositoryImplTest(CharacterRepositoryImpl characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Test
    void findAllByNameContainsFindsCoincidences() {
        String searchQuery = "lars";

        List<CharacterDTO> characters = characterRepository.findAllByNameContains(searchQuery);

        characters.forEach(c -> assertTrue(c.getName().toUpperCase().contains(searchQuery.toUpperCase())));
    }


    @Test
    void findAllByNameContainsThrowsWhenNullQuery() {
        String searchQuery = null;

        assertThrows(NullPointerException.class, () -> characterRepository.findAllByNameContains(searchQuery));
    }
}