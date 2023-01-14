package com.meli.obtenerdiploma.testUnitarios.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService mockStudentService;
    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Responde con un OK si se crea un usuario")
    void registerStudentOK(){
        //Arrange
        StudentDTO stuInput = new StudentDTO(3L, "Alejandro", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        ResponseEntity<?> expectedResponseEntity = ResponseEntity.ok().build();
        //Act
        ResponseEntity<?> responseEntityactual = studentController.registerStudent(stuInput);

        //Assert
        verify(mockStudentService, atLeastOnce()).create(stuInput);
        Assertions.assertEquals(expectedResponseEntity,responseEntityactual);

    }

    @Test
    @DisplayName("Retorna el estudiante por el ID")
    void getStudentOK(){
        //Arrange
        Long id = 1L;
        StudentDTO expectedStu = new StudentDTO(1L, "Diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        when(mockStudentService.read(id)).thenReturn(expectedStu);

        //Act
        StudentDTO actualStudent = studentController.getStudent(id);

        //Assert
        verify(mockStudentService, atLeastOnce()).read(id);
        Assertions.assertEquals(expectedStu,actualStudent);

    }

    @Test
    @DisplayName("Modificar un estudiante DTO")
    void modifyStudentOK(){

        //Arrange
        StudentDTO expectedStu = new StudentDTO(1L, "Camilo", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        ResponseEntity<?> ExpectedResponseEntity = ResponseEntity.ok().build();

        //Act
        studentController.modifyStudent(expectedStu);
        //Assert
        verify(mockStudentService,atLeastOnce()).update(expectedStu);

    }

    @Test
    @DisplayName("Eliminando un estudiante")
    void removeStudentOK(){
        //Arrange
        Long id = 1L;
        ResponseEntity<?> expectedResponseEntity = ResponseEntity.ok().build();
        //Act
        ResponseEntity actualResponseEntity = studentController.removeStudent(id);

        //Assert
        verify(mockStudentService,atLeastOnce()).delete(id);

    }

    @Test
    @DisplayName("Listar estudiantes existentes")
    void listStudentsOK(){
        //Arrange
        Set<StudentDTO> expectedSet = new HashSet<>();
        StudentDTO expectedStu = new StudentDTO(2L, "Diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        StudentDTO expectedStu2 = new StudentDTO(1L, "Juan", null, null, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        expectedSet.add(expectedStu);
        expectedSet.add(expectedStu2);
        when(mockStudentService.getAll()).thenReturn(expectedSet);

        //Act
        Set<StudentDTO> actualSetResponse = studentController.listStudents();
        //Assert
        Assertions.assertEquals(expectedSet,actualSetResponse);
        verify(mockStudentService,atLeastOnce()).getAll();

    }



}
