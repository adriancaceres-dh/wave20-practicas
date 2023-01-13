package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CharacterRepositoryImplTest {

    CharacterRepository characterRepository;

    @Autowired
    public CharacterRepositoryImplTest(CharacterRepositoryImpl characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Test
    public void shouldFindAllByNameContains() {
        String query = "walk";

        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);

        assertTrue(characters.get(0).getName().contains(query));
    }

    @Test
    public void shouldNotFindAllNullQuery () {
        String query = null;

        assertThrows(NullPointerException.class, () -> characterRepository.findAllByNameContains(query));
    }
}
