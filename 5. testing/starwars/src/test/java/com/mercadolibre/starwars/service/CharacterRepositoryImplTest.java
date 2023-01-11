package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepositoryImpl;

    public CharacterRepositoryImplTest(){
        this.characterRepositoryImpl = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContainsTest(){
        String name = "Darth";
        List<CharacterDTO> listcharacter = characterRepositoryImpl.findAllByNameContains(name);

        listcharacter.forEach(c -> assertTrue(c.getName().toUpperCase().contains(name.toUpperCase())));

    }

    @Test
    void findAllByNameContainsThrowsWhenNullName() {
        String name = null;
        assertThrows(NullPointerException.class, () -> characterRepositoryImpl.findAllByNameContains(name));
    }



}
