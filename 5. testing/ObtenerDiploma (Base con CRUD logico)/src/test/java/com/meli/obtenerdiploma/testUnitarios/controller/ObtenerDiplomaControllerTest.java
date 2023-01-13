package com.meli.obtenerdiploma.testUnitarios.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService mockObtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Retorno de un estudiante con su promedio y un mensaje personalizado")
    void analyzeScores(){
        //Arrange
        Long studentId = 1L;
        StudentDTO expectedStu = new StudentDTO(1L, "Diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        when(mockObtenerDiplomaService.analyzeScores(expectedStu.getId())).thenReturn(expectedStu);

        //Act
        StudentDTO actualStudent = obtenerDiplomaController.analyzeScores(studentId);
        //Assert
        Assertions.assertEquals(expectedStu,actualStudent);
    }


}
