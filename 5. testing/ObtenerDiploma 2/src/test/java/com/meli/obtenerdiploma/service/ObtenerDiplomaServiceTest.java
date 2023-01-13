package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    //Cómo calculo los "CASOS BORDE"

    long id=0;

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Caso feliz")
    void analyzeScores() {
        //arrange
        StudentDTO expectedResult = getStudentDto();
        when(iStudentDAO.findById(expectedResult.getId())).thenReturn(expectedResult);
        //act
        StudentDTO result = obtenerDiplomaService.analyzeScores(expectedResult.getId());
        //assertion
        verify(iStudentDAO, atLeastOnce()).findById(expectedResult.getId());
        assertThat(expectedResult).isEqualTo(result);
    }



    public StudentDTO getStudentDto() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("karen");
        studentDTO.setId(++id);
        studentDTO.setAverageScore(9D);
        studentDTO.setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(studentDTO.getAverageScore())
                + ((studentDTO.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."));
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematica");
        subjectDTO.setScore(9D);
        subjects.add(subjectDTO);
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }
}