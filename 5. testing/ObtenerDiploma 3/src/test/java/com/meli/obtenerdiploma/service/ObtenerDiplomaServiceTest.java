package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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
    @DisplayName("")
    void analyzeScores(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        StudentDTO expect = new StudentDTO(1L,"Pedro","",9.0,list);
        when(studentDAO.findById(1L)).thenReturn(expect);
        //act
        StudentDTO actual =  obtenerDiplomaService.analyzeScores(1L);
        //assert
        assertEquals(expect, actual);
    }
    @Test
    @DisplayName("test with first messege")
    void getGreetingMessage(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",9.0));
        list.add(new SubjectDTO("Física",7.0));
        list.add(new SubjectDTO("Química",6.0));
        String name = "Pedro";
        StudentDTO student = new StudentDTO(1L,name,"",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        String expectResult ="El alumno "+ name +" ha obtenido un promedio de 7.33. Puedes mejorar.";
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
    void calculateAverage(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",10.0));
        list.add(new SubjectDTO("Física",10.0));
        list.add(new SubjectDTO("Química",10.0));
        String name = "Pedro";
        StudentDTO student = new StudentDTO(1L,name,"",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        Double expectResult = 10.0;
        //act
        Double actual =  obtenerDiplomaService.analyzeScores(1L).getAverageScore();
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
        String actual =  obtenerDiplomaService.analyzeScores(1L).getMessage();
        //assert
        assertEquals(expectResult, actual);
    }
    @Test
    void calculateAverageNull(){
        //arrange
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",6.0));
        list.add(new SubjectDTO("Física",6.0));
        list.add(new SubjectDTO("Química",6.0));
        String name = "Pedro";
        StudentDTO student = new StudentDTO(1L,name,"",0.0,list);
        when(studentDAO.findById(1L)).thenReturn(student);
        Double expectResult = 6.0;
        //act
        Double actual =  obtenerDiplomaService.analyzeScores(1L).getAverageScore();
        //assert
        assertEquals(expectResult, actual);
    }

}