package com.meli.obtenerdiploma2.service;

import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.model.SubjectDTO;
import com.meli.obtenerdiploma2.repository.IStudentDAO;
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

    private StudentDTO student;

    @BeforeEach
    void setup (){
        SubjectDTO sub1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO sub2 = new SubjectDTO("Física", 5.0);
        SubjectDTO sub3 = new SubjectDTO("Química", 6.0);
        student = new StudentDTO(12L, "Felipe", "", 0.0, Arrays.asList(sub1,sub2,sub3));

    }
    @Test
    void checkValidAverage() {
        //Arrange
        when(studentDAO.findById(student.getId())).thenReturn(student);
        //Act
        service.analyzeScores(student.getId());
        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(6.0, student.getAverageScore());
    }

    @Test
    void checkValidMessageScoreBelow9() {
        //Arrange
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        service.analyzeScores(student.getId());
        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Felipe ha obtenido un promedio de 6.00. Puedes mejorar.", student.getMessage());
    }




}