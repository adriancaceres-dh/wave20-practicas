package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        verify(studentService, atLeast(1)).create(student);
    }

    @Test
    void getStudentOk() {
        // arrange
        Long id = 10L;
        StudentDTO expected = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentService.read(anyLong())).thenReturn(expected);
        // act
        StudentDTO actual = studentController.getStudent(id);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    void getStudentException() {
        // arrange
        Long id = 10L;
        when(studentService.read(anyLong())).thenThrow(StudentNotFoundException.class);
        // act
        Executable executable = () -> studentController.getStudent(id);
        // assert
        assertThrows(StudentNotFoundException.class, executable);
    }

    @Test
    void modifyStudentOk() {
        // arrange
        StudentDTO student = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        doNothing().when(studentService).update(isA(StudentDTO.class));
        // act
        studentController.modifyStudent(student);
        // assert
        verify(studentService, atLeast(1)).update(student);
    }

    @Test
    void removeStudentOk() {
        // arrange
        Long id = 10L;
        doNothing().when(studentService).delete(anyLong());
        // act
        studentController.removeStudent(id);
        // assert
        verify(studentService, atLeast(1)).delete(id);
    }

    @Test
    void listStudentsOk() {
        // arrange
        Set<StudentDTO> expectedStudents = createStudentList();
        when(studentService.getAll()).thenReturn(expectedStudents);
        // act
        Set<StudentDTO> currentStudents = studentController.listStudents();
        // assert
        assertEquals(expectedStudents, currentStudents);
    }

    Set<StudentDTO> createStudentList() {
        return Set.of(
                new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D))),
                new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 8D), new SubjectDTO("Química", 4D)))
        );
    }
}
