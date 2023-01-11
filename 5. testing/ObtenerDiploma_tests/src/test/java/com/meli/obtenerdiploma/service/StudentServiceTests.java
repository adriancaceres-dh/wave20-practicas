package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void createOk() {
        // arrange
        StudentDTO student = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        doNothing().when(studentDAO).save(isA(StudentDTO.class));
        // act
        studentService.create(student);
        // assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    void readOk() {
        // arrange
        StudentDTO expected = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentDAO.findById(anyLong())).thenReturn(expected);
        // act
        StudentDTO actual = studentService.read(1L);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    void readException() {
        // arrange
        Long id = 10L;
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);
        // act
        Executable executable = () -> studentService.read(id);
        // assert
        assertThrows(StudentNotFoundException.class, executable);
    }

    @Test
    void updateOk() {
        // arrange
        StudentDTO student = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        doNothing().when(studentDAO).save(isA(StudentDTO.class));
        // act
        studentService.update(student);
        // assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    void deleteOk() {
        // arrange
        Long id = 10L;
        when(studentDAO.delete(anyLong())).thenReturn(true);
        // act
        studentService.delete(id);
        // assert
        verify(studentDAO, atLeast(1)).delete(id);
    }

    @Test
    void getAllOk() {
        // arrange
        Set<StudentDTO> expectedStudents = createStudentList();
        when(studentRepository.findAll()).thenReturn(expectedStudents);
        // act
        Set<StudentDTO> currentStudents = studentService.getAll();
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
