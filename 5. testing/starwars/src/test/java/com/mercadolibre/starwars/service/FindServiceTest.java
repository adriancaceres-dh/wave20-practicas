package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service;

    @Test
    public void testFind() {
        // arrange
        String query = "Darth";
        CharacterDTO character1 =new CharacterDTO("Darth Vader", null, "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO character2 = new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80);
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(character1);
        characterDTOList.add(character2);

        when(characterRepository.findAllByNameContains(query)).thenReturn(characterDTOList);
        // act
        List<CharacterDTO> resultList = service.find(query);

        // assert
        assertEquals(character1.getName(),resultList.get(0).getName());
    }

}