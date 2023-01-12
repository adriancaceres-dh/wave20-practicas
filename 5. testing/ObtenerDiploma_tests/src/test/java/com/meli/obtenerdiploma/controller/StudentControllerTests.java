package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentOk() {
        // arrange
        StudentDTO student = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        doNothing().when(studentService).create(isA(StudentDTO.class));
        // act
        studentController.registerStudent(student);
        // assert
        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    void getStudentOk() {
        // arrange
        Long id = 10L;
        StudentDTO expected = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentService.read(id)).thenReturn(expected);
        // act
        StudentDTO actual = studentController.getStudent(id);
        // assert
        verify(studentService, atLeastOnce()).read(id);
        assertEquals(expected, actual);
    }

    @Test
    void modifyStudentOk() {
        // arrange
        StudentDTO student = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        doNothing().when(studentService).update(isA(StudentDTO.class));
        // act
        studentController.modifyStudent(student);
        // assert
        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    void removeStudentOk() {
        // arrange
        Long id = 10L;
        doNothing().when(studentService).delete(id);
        // act
        studentController.removeStudent(id);
        // assert
        verify(studentService, atLeastOnce()).delete(id);
    }

    @Test
    void listStudentsOk() {
        // arrange
        Set<StudentDTO> expectedStudents = createStudentList();
        when(studentService.getAll()).thenReturn(expectedStudents);
        // act
        Set<StudentDTO> currentStudents = studentController.listStudents();
        // assert
        verify(studentService, atLeastOnce()).getAll();
        assertEquals(expectedStudents, currentStudents);
    }

    Set<StudentDTO> createStudentList() {
        return Set.of(
                new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D))),
                new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 8D), new SubjectDTO("Química", 4D)))
        );
    }
}
