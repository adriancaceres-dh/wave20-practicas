package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analizeScoreTestOk(){
        //Arrange
        Long id = 55L;
        StudentDTO expected= new StudentDTO();
        when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(expected);
        //Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(id);
        //Assert
        verify(iObtenerDiplomaService,times(1)).analyzeScores(id);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void analizeScoreTestNotFound(){
        //Arrange
        Long id = 55L;
        when(iObtenerDiplomaService.analyzeScores(id)).thenThrow(new StudentNotFoundException(id));
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->obtenerDiplomaController.analyzeScores(id));
        verify(iObtenerDiplomaService,times(1)).analyzeScores(id);
    }

}
