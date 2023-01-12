package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController controller;

    @Test
    void testFindController(){
        //arrange
        String query = "Darth";
        CharacterDTO character1 =new CharacterDTO("Darth Vader", null, "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO character2 = new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80);
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(character1);
        characterDTOList.add(character2);
        when(findService.find(query)).thenReturn(characterDTOList);

        //Action
        List<CharacterDTO> resultList = controller.find(query);

        //Assert
        assertTrue(resultList.size() > 0);
        assertEquals(character2.getName(),resultList.get(1).getName());
    }

}