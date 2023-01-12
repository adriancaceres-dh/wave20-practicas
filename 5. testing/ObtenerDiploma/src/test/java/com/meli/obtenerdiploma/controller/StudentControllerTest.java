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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        //Arrange
        List<SubjectDTO> subjectDTOList=new ArrayList<>();
        SubjectDTO Maths=new SubjectDTO("Matematicas",9.5);
        subjectDTOList.add(Maths);
        StudentDTO stu=new StudentDTO(1L,"David",subjectDTOList);

        //Act
        ResponseEntity<?> response=studentController.registerStudent(stu);

        //Assert
        verify(studentService,atLeast(1)).create(stu);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getStudent() {
        //Arrange
        List<SubjectDTO> subjectDTOList=new ArrayList<>();
        SubjectDTO Maths=new SubjectDTO("Matematicas",9.5);
        subjectDTOList.add(Maths);
        StudentDTO stu=new StudentDTO(1L,"David",subjectDTOList);
        Long id=1L;
        when(studentService.read(1L)).thenReturn(stu);
        //Act
        StudentDTO response=studentController.getStudent(id);

        //Assert

        assertEquals(stu, response);


    }

    @Test
    void modifyStudent() {
        //Arrange
        List<SubjectDTO> subjectDTOList=new ArrayList<>();
        SubjectDTO Maths=new SubjectDTO("Matematicas",9.5);
        subjectDTOList.add(Maths);
        StudentDTO stu=new StudentDTO(1L,"David",subjectDTOList);

        //Act
        ResponseEntity<?> response=studentController.modifyStudent(stu);

        //Assert
        verify(studentService,atLeast(1)).update(stu);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void removeStudent() {
        //Arrange
        long id=1L;

        //Act
        ResponseEntity<?> response=studentController.removeStudent(id);

        //Assert
        verify(studentService,atLeast(1)).delete(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void listStudents() {
        //Arrange
        List<SubjectDTO> subjectDTOList=new ArrayList<>();
        SubjectDTO Maths=new SubjectDTO("Matematicas",9.5);
        subjectDTOList.add(Maths);
        Set<StudentDTO> allStudents=new HashSet<>();
        allStudents.add(new StudentDTO(1L,"David",subjectDTOList));
        allStudents.add(new StudentDTO(2L,"Pepito",subjectDTOList));

        when(studentService.getAll()).thenReturn(allStudents);

        //Act
        Set<StudentDTO> response=studentController.listStudents();
        //Assert

        Assertions.assertEquals(allStudents,response);
    }
}