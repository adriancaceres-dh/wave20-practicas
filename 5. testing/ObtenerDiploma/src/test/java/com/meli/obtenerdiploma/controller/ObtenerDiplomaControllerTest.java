package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService service;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresOK() {
        //Arrange
        StudentDTO studentExpected = new StudentDTO(1L, "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,
                List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));

        Long studentId = 1L;
        when(service.analyzeScores(studentId)).thenReturn(studentExpected);

        //Act
        StudentDTO studentResponse = obtenerDiplomaController.analyzeScores(studentId);

        //Assert
        Assertions.assertEquals(studentExpected, studentResponse);

    }

}