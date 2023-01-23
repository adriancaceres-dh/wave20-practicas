package com.meli.obtenerdiploma.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService mockStudentService;

    @InjectMocks
    private StudentController injectMockStudentController;

    @Test
    @DisplayName("US-001 Registro estudiante Camino Feliz ....")
    void registerStudentControllerTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //ResponseEntity<?> expectedResponseEntity = new ResponseEntity<>(null, HttpStatus.OK);

        //Act
        //ResponseEntity<?> actualResponseEntity = injectMockStudentController.registerStudent(studentDTO);
        injectMockStudentController.registerStudent(studentDTO);
        //Assert

        //Assertions.assertEquals(expectedResponseEntity, actualResponseEntity);

        verify(mockStudentService, atLeastOnce()).create(studentDTO);
    }

    @Test
    void getStudentControllerTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        when(mockStudentService.read(studentId)).thenReturn(expectedStudentDTO);
        //Act
        StudentDTO actualStudentDTO = injectMockStudentController.getStudent(studentId);

        //Assert
        Assertions.assertEquals(expectedStudentDTO, actualStudentDTO);
    }

    @Test
    void modifyStudentControllerTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act
        injectMockStudentController.modifyStudent(studentDTO);

        //Assert
        verify(mockStudentService, atLeastOnce()).update(studentDTO);
    }

    @Test
    void removeStudentControllerTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        //Act
        injectMockStudentController.removeStudent(studentDTO.getId());

        //Assert
        verify(mockStudentService, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void listStudentsControllerTest() {
        //Arrange
        Set<StudentDTO> expectedListStudents = new HashSet<>();
        StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        expectedListStudents.add(studentDTO1);

        StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)));
        expectedListStudents.add(studentDTO2);
        when(mockStudentService.getAll()).thenReturn(expectedListStudents);

        //Act
        Set<StudentDTO> actualListStudent = injectMockStudentController.listStudents();
        //Assert
        Assertions.assertEquals(expectedListStudents, actualListStudent);
        Assertions.assertEquals(expectedListStudents.size(), actualListStudent.size());
    }
}
