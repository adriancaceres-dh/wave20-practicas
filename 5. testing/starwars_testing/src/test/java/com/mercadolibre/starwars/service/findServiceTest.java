package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
public class findServiceTest {

    @InjectMocks
    public FindService findService;

    @Mock
    public CharacterRepositoryImpl characterRepository;

    @Test
    public void findOk(){
        //Arrange
        List<CharacterDTO> expectedCharacterList = new ArrayList<>();
        expectedCharacterList.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        expectedCharacterList.add(new CharacterDTO("Luminara Unduli","black","yellow","blue","58BBY","female","Mirial","Mirialan",170,56));

        when(characterRepository.findAllByNameContains("lu")).thenReturn(expectedCharacterList);
        //act

        List<CharacterDTO> actualCharacterList = findService.find("lu");
        verify(characterRepository, atLeast(1)).findAllByNameContains("lu");

        //Assert

        Assertions.assertEquals(expectedCharacterList,actualCharacterList);
    }
}
