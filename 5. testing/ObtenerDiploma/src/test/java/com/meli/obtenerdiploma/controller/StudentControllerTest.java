package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {



    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO studentDTO;
    private Set<StudentDTO> setStudentDto;


    public StudentControllerTest() {
        List<SubjectDTO> listSubjectDto = new ArrayList<>();
        listSubjectDto.add(SubjectDTO.builder().name("Prueba").score(2.0).build());
        listSubjectDto.add(SubjectDTO.builder().name("Prueba2").score(3.0).build());
        studentDTO =  StudentDTO.builder().id(1L).studentName("Juan").averageScore(2.0).message("Nuevo").averageScore(2.0).subjects(listSubjectDto).build();
        setStudentDto = new HashSet<>();
        setStudentDto.add(studentDTO);

    }

    @Test
    void findStudentById(){
        Long id = Long.valueOf(1);

        when(iStudentService.read(id)).thenReturn(studentDTO);

        StudentDTO studentDTOExpected = studentController.getStudent(id);

        assertNotNull(studentDTOExpected);
        assertEquals(studentDTO, studentDTOExpected);

    }

    @Test
    void findAllStudents(){

        when(iStudentService.getAll()).thenReturn(setStudentDto);

        Set<StudentDTO> studentDtoExpected = studentController.listStudents();

        assertNotNull(studentDtoExpected);
        assertEquals(setStudentDto, studentDtoExpected);

    }
}
