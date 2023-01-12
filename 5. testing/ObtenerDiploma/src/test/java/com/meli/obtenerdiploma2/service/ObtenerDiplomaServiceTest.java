package com.meli.obtenerdiploma2.service;

import com.meli.obtenerdiploma2.exception.StudentNotFoundException;
import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.repository.IStudentDAO;
import com.meli.obtenerdiploma2.utils.StudentUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)

class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO mockStudentDAO;

    @InjectMocks
    ObtenerDiplomaService mockObtenerDiplomaService;

    @Test
    @DisplayName("Same In and Out Border test - Camino Feliz :D")
    void shouldHaveSameOutputAndInputOneSubject() {
        //arrange
        StudentDTO actual = StudentUtilsGenerator.getStudentOneSubject();

        Mockito.when(mockStudentDAO.findById(actual.getId())).thenReturn(actual);
        //act
        mockObtenerDiplomaService.analyzeScores(actual.getId());
        //assert
        assertEquals(8.0, actual.getAverageScore());
    }
    @Test
    @DisplayName("Average Score Many Subjects - Camino Feliz :D")
    void shouldGetAverageScoreManySubjects() {
        //arrange
        StudentDTO expected = StudentUtilsGenerator.getStudentResultsManySubjects();
        StudentDTO actual = StudentUtilsGenerator.getStudentManySubjects();

        Mockito.when(mockStudentDAO.findById(actual.getId())).thenReturn(actual);
        //act
        mockObtenerDiplomaService.analyzeScores(actual.getId());
        //assert
        assertEquals(expected.getAverageScore(), actual.getAverageScore());
    }

    @Test
    @DisplayName("Mensaje Below 9 OK - Camino Feliz :D")
    void shouldSetMessageForBelow9(){
        //arrange
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 6.33. Puedes mejorar.";
        StudentDTO student = StudentUtilsGenerator.getStudentManySubjects();
        Mockito.when(mockStudentDAO.findById(1L)).thenReturn(student);
        //act
        mockObtenerDiplomaService.analyzeScores(1L);
        //assert
        assertEquals(expectedMessage, student.getMessage());
    }


    @Test
    @DisplayName("Mensaje Over 9 OK - Camino Feliz :D")
    void shouldSetMessageForOver9(){
        //arrange
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 10.00. Felicitaciones!";
        StudentDTO student = StudentUtilsGenerator.getStudentManySubjectsOver9();
        Mockito.when(mockStudentDAO.findById(1L)).thenReturn(student);
        //act
        mockObtenerDiplomaService.analyzeScores(1L);
        //assert
        assertEquals(expectedMessage, student.getMessage());
    }

    @Test
    @DisplayName("Caso ID nulo")
    void analyzeScoreNullId() {
        //arrange
        String expected = "El alumno con Id " + null + " no se encuentra registrado.";
        Mockito.when(mockStudentDAO.findById(null)).thenThrow(new StudentNotFoundException(null));

        //act
        Exception actual = assertThrows(StudentNotFoundException.class, () -> mockObtenerDiplomaService.analyzeScores(null));

        //assert
        assertEquals(expected, actual.getMessage());
    }


}