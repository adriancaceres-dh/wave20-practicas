package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceConMockTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    StudentDTO studentDTO;
    SubjectDTO subjectDTO;
    List<SubjectDTO> subjectDTOList;
    @BeforeEach
    void preCargaForService(){
        subjectDTOList = new ArrayList<>();
        subjectDTO = new SubjectDTO("Matematica", 6.0);
        subjectDTOList.add(subjectDTO);
        subjectDTO = new SubjectDTO("Lenguaje", 7.0);
        subjectDTOList.add(subjectDTO);
        subjectDTO = new SubjectDTO("Historia", 5.0);
        subjectDTOList.add(subjectDTO);
        // arrange
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("armando");
        studentDTO.setId(1L);
        studentDTO.setMessage("");
        studentDTO.setSubjects(subjectDTOList);
    }

    @Test
    @DisplayName("camino feliz Promedio nota")
    void TestNotaSalida(){
        //arange

        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        // act
        obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals(6.0, studentDTO.getAverageScore());

    }

    @Test
    void averageScoreOver9MessageWellWritten(){
        //arange
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        // act
        obtenerDiplomaService.analyzeScores(studentDTO.getId()).getMessage();
        // assert
        //verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals("El alumno armando ha obtenido un promedio de 6. Puedes mejorar.", studentDTO.getMessage());
    }
    @Test
    void averageScoreBelow9MessageWellWritten(){
        studentDTO.getSubjects().forEach(x->x.setScore(9.5));
        //arange
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        // act
        obtenerDiplomaService.analyzeScores(studentDTO.getId()).getMessage();
        // assert
        //verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals("El alumno armando ha obtenido un promedio de 9,5. Felicitaciones!", studentDTO.getMessage());
    }

}