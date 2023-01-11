package com.meli.obtenerdiploma.service;

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


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAOMock;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void getGreetingMessageCongratulations(){
        //Arrange
        String studentName = "Ignacio";
        String expectedOutput = "El alumno " + studentName + " ha obtenido un promedio de " + 9.05 + ". Felicitaciones!";
        SubjectDTO sub1 = new SubjectDTO("Matematica",9.10);
        SubjectDTO sub2 = new SubjectDTO("Historia",9.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);
        StudentDTO res = new StudentDTO(4L,"Ignacio","",0.00,subjects);

        when(studentDAOMock.findById(any())).thenReturn(res);

        //Act
        StudentDTO output = obtenerDiplomaService.analyzeScores(4L);

        //Assert

        assertEquals(expectedOutput,output.getMessage());

    }

    @Test
    public void getGreetingMessageYouCanImprove(){
        //Arrange
        String studentName = "Ignacio";
        String expectedOutput = "El alumno " + studentName + " ha obtenido un promedio de " + 8 + ". Puedes mejorar.";
        SubjectDTO sub1 = new SubjectDTO("Matematica",8.00);
        SubjectDTO sub2 = new SubjectDTO("Historia",8.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);
        StudentDTO res = new StudentDTO(4L,"Ignacio","",0.00,subjects);

        when(studentDAOMock.findById(any())).thenReturn(res);

        //Act
        StudentDTO output = obtenerDiplomaService.analyzeScores(4L);

        //Assert
        assertEquals(expectedOutput,output.getMessage());

    }

}
