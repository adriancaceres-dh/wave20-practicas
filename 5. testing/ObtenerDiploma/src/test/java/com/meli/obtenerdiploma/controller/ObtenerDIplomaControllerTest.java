package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDIplomaControllerTest {



    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO studentDTO;

    public ObtenerDIplomaControllerTest() {
        List<SubjectDTO> listSubjectDto = new ArrayList<>();
        listSubjectDto.add(SubjectDTO.builder().name("Prueba").score(2.0).build());
        listSubjectDto.add(SubjectDTO.builder().name("Prueba2").score(3.0).build());
        studentDTO =  StudentDTO.builder().id(1L).studentName("Juan").averageScore(2.0).message("Nuevo").averageScore(2.0).subjects(listSubjectDto).build();

    }

    @Test
    void testAnalyzeScore(){
        Long id = 1L;
        when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(studentDTO);
        StudentDTO studentDTOExpected = obtenerDiplomaController.analyzeScores(id);
        assertEquals(studentDTO, studentDTOExpected);

    }


}
