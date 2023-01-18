package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Rollback
    @Test
    void testFindAllByNameContains(){
        //Arrange
        String query = "Darth";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Darth Vader");
        characterDTO1.setHeight(202);
        characterDTO1.setMass(136);
        characterDTO1.setHair_color("none");
        characterDTO1.setSkin_color("white");
        characterDTO1.setEye_color("yellow");
        characterDTO1.setBirth_year("41.9BBY");
        characterDTO1.setGender("male");
        characterDTO1.setHomeworld("Tatooine");
        characterDTO1.setSpecies("Human");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Darth Maul");
        characterDTO2.setHeight(175);
        characterDTO2.setMass(80);
        characterDTO2.setHair_color("none");
        characterDTO2.setSkin_color("red");
        characterDTO2.setEye_color("yellow");
        characterDTO2.setBirth_year("54BBY");
        characterDTO2.setGender("male");
        characterDTO2.setHomeworld("Dathomir");
        characterDTO2.setSpecies("Zabrak");

        List<CharacterDTO> expectedList = List.of(characterDTO1,characterDTO2);

        //Act
        List<CharacterDTO> actualList = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertEquals(expectedList.toString(),actualList.toString());
    }

    @Test
    void matchWith(){
        //Arrange
        boolean expectedResponse = true;
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("human");

        //Act
        boolean actualResponse = characterRepository.matchWith(query, characterDTO);

        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);

    }

    @Test
    void loadDataBase(){
        //Arrange
        int expectedSizeOfList = 87;
        //Act
        int actualSizeOfList = characterRepository.loadDataBase().size();
        //Assert
        Assertions.assertEquals(expectedSizeOfList,actualSizeOfList);

    }

}
