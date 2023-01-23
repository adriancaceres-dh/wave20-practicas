package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {
    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
    @Test
    public void findAllByNameContainsTest(){
        List<CharacterDTO> list = characterRepository.findAllByNameContains("Darklighter");
        CharacterDTO characterDTO = new CharacterDTO();

        Assertions.assertEquals("Biggs Darklighter",list.get(0).getName());
        Assertions.assertEquals("black",list.get(0).getHair_color());
        Assertions.assertEquals("light",list.get(0).getSkin_color());
        Assertions.assertEquals("brown",list.get(0).getEye_color());
        Assertions.assertEquals("24BBY",list.get(0).getBirth_year());
        Assertions.assertEquals("male",list.get(0).getGender());
        Assertions.assertEquals("Tatooine",list.get(0).getHomeworld());
        Assertions.assertEquals("Human",list.get(0).getSpecies());
        Assertions.assertEquals(183,list.get(0).getHeight());
        Assertions.assertEquals(84,list.get(0).getMass());

    }
}
