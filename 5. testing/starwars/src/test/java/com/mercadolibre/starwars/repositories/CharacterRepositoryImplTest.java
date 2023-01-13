

package com.mercadolibre.starwars.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository;

    @Autowired
    public CharacterRepositoryImplTest(CharacterRepositoryImpl characterRepository) {
        this.repository = characterRepository;
    }

    @Test
    void whenQueryIsNullThenThrowException() {
        String query = null;
        assertThrows(NullPointerException.class, () -> repository.findAllByNameContains(query));
    }
}