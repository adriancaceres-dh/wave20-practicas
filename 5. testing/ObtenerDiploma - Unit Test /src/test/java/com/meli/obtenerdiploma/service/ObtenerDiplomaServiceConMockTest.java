package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceConMockTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    static StudentDTO generateStudentDTO(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 8.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 7.0));
        return new StudentDTO(3L, "Juan", "", 0.00, subjectDTOList);
    }

    static StudentDTO generateStudentDTOAverageScore9(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 9.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 10.0));
        return new StudentDTO(3L, "Juan", "", 0.00, subjectDTOList);
    }

    @Test
    void analyzeScoresOk() {
        //arrange
        StudentDTO studentExpected = generateStudentDTO();
        when(studentDAO.findById(anyLong())).thenReturn(studentExpected);
        //act
        StudentDTO studentActual = obtenerDiplomaService.analyzeScores(3L);
        //assert
        Assertions.assertEquals(studentExpected, studentActual);
    }

    @Test
    void calculateAverageOk() {
        //arrange
        StudentDTO studentExpected = generateStudentDTO();
        when(studentDAO.findById(anyLong())).thenReturn(studentExpected);
        //act
        obtenerDiplomaService.analyzeScores(studentExpected.getId());
        //assert
        Assertions.assertEquals(7.5, studentExpected.getAverageScore());
        verify(studentDAO, atLeast(1)).findById(studentExpected.getId());
    }

    @Test
    void calculateAverageScore9Ok() {
        //arrange
        StudentDTO studentExpected = generateStudentDTOAverageScore9();
        when(studentDAO.findById(anyLong())).thenReturn(studentExpected);
        //act
        obtenerDiplomaService.analyzeScores(studentExpected.getId());
        //assert
        Assertions.assertEquals(9.5, studentExpected.getAverageScore());
        verify(studentDAO, atLeast(1)).findById(studentExpected.getId());
    }

    @Test
    void GreetingMessageOk() {
        //arrange
        StudentDTO studentExpected = generateStudentDTO();
        when(studentDAO.findById(anyLong())).thenReturn(studentExpected);
        //act
        obtenerDiplomaService.analyzeScores(studentExpected.getId());
        //assert
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 7.5. Puedes mejorar.", studentExpected.getMessage());
        verify(studentDAO, atLeast(1)).findById(studentExpected.getId());
    }

    @Test
    void GreetingMessageScore9Ok() {
        //arrange
        StudentDTO studentExpected = generateStudentDTOAverageScore9();
        when(studentDAO.findById(anyLong())).thenReturn(studentExpected);
        //act
        obtenerDiplomaService.analyzeScores(studentExpected.getId());
        //assert
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 9.5. Felicitaciones!", studentExpected.getMessage());
        verify(studentDAO, atLeast(1)).findById(studentExpected.getId());
    }
}