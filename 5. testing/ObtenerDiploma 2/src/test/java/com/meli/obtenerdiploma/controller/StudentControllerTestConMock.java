package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;


@ExtendWith(MockitoExtension.class)
public class StudentControllerTestConMock {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;
    @Test
    void getStudentTestOk(){
        //Arrange
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Pedro");
        expected.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));
        when(studentService.read(expected.getId())).thenReturn(expected);
        //Act
        StudentDTO result = studentController.getStudent(expected.getId());
        //assert
        verify(studentService, atLeastOnce()).read(expected.getId());
        Assertions.assertEquals(expected,result);

    }

    @Test
    void  modifyStudent(){
        //Arrange
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Pedro");
        expected.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));
        //Act
        studentController.modifyStudent(expected);
        //assert
        verify(studentService, atLeastOnce()).update(expected);

    }
    @Test
    void removeStudent(){
        //Arrange
        StudentDTO expected = new StudentDTO();
        expected.setId(1L);
        expected.setStudentName("Pedro");
        expected.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));

        //Act
        studentController.removeStudent(expected.getId());
        //assert
        verify(studentService, atLeastOnce()).delete(expected.getId());
    }
    @Test
    void listStudents(){
        //Arrange
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(1L);
        studentDTO1.setStudentName("Pedro");
        studentDTO1.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(2L);
        studentDTO2.setStudentName("Juan");
        studentDTO2.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(studentDTO1);
        studentDTOSet.add(studentDTO2);
        studentDTOSet.add(studentDTO);

        when(studentService.getAll()).thenReturn(studentDTOSet);
        //Act
        Set<StudentDTO> result = studentController.listStudents();
        //assert
        Assertions.assertEquals(studentDTOSet,result);
    }
}
