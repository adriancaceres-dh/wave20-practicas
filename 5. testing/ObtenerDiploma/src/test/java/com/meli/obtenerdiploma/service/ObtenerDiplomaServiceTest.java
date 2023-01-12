package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO mockStudentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void testAnalyzeScores(){
        //Arrange
        Long idQuery = 1L;
        String message= "El alumno Andres ha obtenido un promedio de 4.25. Puedes mejorar.";
        List<SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO stu = new StudentDTO(1L,"Andres",message,10.0,subjectsDTOS);

        when(mockStudentDAO.findById(idQuery)).thenReturn(stu);

        //act
        StudentDTO studentResult = obtenerDiplomaService.analyzeScores(idQuery);

        //asserts
        assertNotNull(studentResult);
        assertEquals(message,stu.getMessage());
        assertEquals(4.25,stu.getAverageScore());
    }

}