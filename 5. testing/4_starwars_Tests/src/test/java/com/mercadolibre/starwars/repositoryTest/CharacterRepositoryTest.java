package com.mercadolibre.starwars.repositoryTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryTest {

    CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    public void findAllByNameContainsTestOk(){
        //Arrange
        String query= "Darth";
        CharacterDTO char1= new CharacterDTO();
        CharacterDTO char2= new CharacterDTO();
        char1.setName("Darth Vader");
        char2.setName("Darth Maul");
        List<CharacterDTO> expected= new ArrayList<>(){{
            add(char1);
            add(char2);
        }};
        //Act
        List<CharacterDTO> result= characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(result.get(0).getName(),char1.getName());
        Assertions.assertEquals(result.get(1).getName(),char2.getName());
    }

    @Test
    public void findAllByNameContainsTestNothingFound(){
        //Arrange
        String query= "Ricardo Darin";
        //Act
        List<CharacterDTO> result= characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertTrue(result.isEmpty());
    }


}
