package com.mercadolibre.starwars.serviceTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    public void findTestOk(){
        //Arrange
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(new ArrayList<>());
        //Act
        List<CharacterDTO> response = findService.find(anyString());
        //Assert
        Assertions.assertEquals(ArrayList.class,response.getClass());
        verify(characterRepository,times(1)).findAllByNameContains(anyString());
    }

}
