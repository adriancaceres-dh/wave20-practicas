package com.meli.obtenerdiploma2.service;

import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.model.SubjectDTO;
import com.meli.obtenerdiploma2.repository.IStudentDAO;
import com.meli.obtenerdiploma2.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService service;


    @Test
    void checkValidAverage() {
        //Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects();
        when(studentDAO.findById(student.getId())).thenReturn(student);
        //Act
        service.analyzeScores(student.getId());
        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(7, Math.round(student.getAverageScore()));
    }

    @Test
    void checkValidMessageScoreBelow9() {
        //Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects();
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        service.analyzeScores(student.getId());
        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Felipe ha obtenido un promedio de 6.00. Puedes mejorar.", student.getMessage());
    }




}