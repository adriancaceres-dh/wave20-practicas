package com.mercadolibre.starwars.controllerTest;

import com.mercadolibre.starwars.controller.FindController;
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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    public void findTestOk(){
        //Arrange
        when(findService.find(anyString())).thenReturn(new ArrayList<>());
        //Act
        List<CharacterDTO> response = findController.find(anyString());
        //Assert
        Assertions.assertEquals(ArrayList.class,response.getClass());
        verify(findService,times(1)).find(anyString());
    }

}
