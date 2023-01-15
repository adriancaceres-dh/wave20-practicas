package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findOk(){
        //Arrange
        List<CharacterDTO> expectedCharacterList = new ArrayList<>();
        expectedCharacterList.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        expectedCharacterList.add(new CharacterDTO("Luminara Unduli","black","yellow","blue","58BBY","female","Mirial","Mirialan",170,56));

        when(findService.find("lu")).thenReturn(expectedCharacterList);
        //act

        List<CharacterDTO> actualCharacterList = findController.find("lu");
        verify(findService, atLeast(1)).find("lu");
        expectedCharacterList.get(0).setGender("female");

        //Assert

        Assertions.assertEquals(expectedCharacterList,actualCharacterList);

    }
}
