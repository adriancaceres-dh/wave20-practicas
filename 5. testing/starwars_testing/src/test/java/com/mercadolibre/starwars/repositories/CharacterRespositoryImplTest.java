package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CharacterRespositoryImplTest {

    @InjectMocks
    public CharacterRepositoryImpl characterRepository;

    @Test
    public void findOk(){
        //Arrange
        List<CharacterDTO> expectedCharacterList = new ArrayList<>();
        expectedCharacterList.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        expectedCharacterList.add(new CharacterDTO("Luminara Unduli","black","yellow","blue","58BBY","female","Mirial","Mirialan",170,56));

        //act
        List<CharacterDTO> actualCharacterList = characterRepository.findAllByNameContains("lu");

        //Assert
        Assertions.assertEquals(expectedCharacterList,actualCharacterList);

    }
}
