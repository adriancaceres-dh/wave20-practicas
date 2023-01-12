package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analizeScores(){
        //Asseert
        StudentDTO expectedstudentDTO = new StudentDTO();
        expectedstudentDTO.setId(2L);
        expectedstudentDTO.setStudentName("Pedro");
        expectedstudentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));
        expectedstudentDTO.setMessage("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.");
        expectedstudentDTO.setAverageScore(7.333333333333333);

        //act
        when(obtenerDiplomaService.analyzeScores(2L)).thenReturn(expectedstudentDTO);

        StudentDTO actualStudentDto = obtenerDiplomaController.analyzeScores(2L);

        //Assert
        Assertions.assertEquals(expectedstudentDTO,actualStudentDto);
        verify(obtenerDiplomaService,atLeast(1)).analyzeScores(2L);

    }
}
