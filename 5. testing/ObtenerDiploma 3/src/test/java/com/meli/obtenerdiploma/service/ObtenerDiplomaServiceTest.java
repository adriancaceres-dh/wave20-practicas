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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        StudentDTO student = new StudentDTO(1L,"Pedro","",9.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        //act
        StudentDTO actual =  obtenerDiplomaService.analyzeScores(1L);
        //assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
    }
    @Test
    @DisplayName("test with first messege")
    void getGreetingMessage(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",8.0));
        list.add(new SubjectDTO("Física",9.0));
        list.add(new SubjectDTO("Química",10.0));
        String name = "Pedro";
        StudentDTO student = new StudentDTO(1L,name,"",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        String expectResult ="El alumno "+ name +" ha obtenido un promedio de 9. Puedes mejorar.";
        //act
        String actual =  obtenerDiplomaService.analyzeScores(1L).getMessage();
        //assert
        assertEquals(expectResult, actual);
    }

    @Test
    @DisplayName("Test with second messege")
    void GreetingMessage(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",10.0));
        list.add(new SubjectDTO("Física",10.0));
        list.add(new SubjectDTO("Química",10.0));
        String name = "Pedro";
        StudentDTO student = new StudentDTO(1L,name,"",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        String expectResult ="El alumno "+ name +" ha obtenido un promedio de 10. Felicitaciones!";
        //act
        String actual =  obtenerDiplomaService.analyzeScores(1L).getMessage();
        //assert
        assertEquals(expectResult, actual);
    }

    @Test
    @DisplayName("Test without a list for avg")
    void GreetingMessageNan(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        String name = "Pedro";
        StudentDTO student = new StudentDTO(1L,name,"",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        String expectResult ="El alumno "+ name +" ha obtenido un promedio de NaN. Puedes mejorar.";
        //act
        obtenerDiplomaService.analyzeScores(1L);
        //assert
        assertEquals(expectResult, student.getMessage());
    }
    @Test
    void calculateAverage(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",6.0));
        list.add(new SubjectDTO("Física",6.0));
        list.add(new SubjectDTO("Química",6.0));
        StudentDTO student = new StudentDTO(1L,"Pedro","",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        //act
        obtenerDiplomaService.analyzeScores(1L);
        //assert
        assertEquals(6.0, student.getAverageScore());
    }


}