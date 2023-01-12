package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void readOk() {
        // arrange
        StudentDTO expected = new StudentDTO(10L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentDAO.findById(expected.getId())).thenReturn(expected);
        // act
        StudentDTO actual = studentService.read(expected.getId());
        // assert
        verify(studentDAO, atLeastOnce()).findById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test
    void updateOk() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));
        doNothing().when(studentDAO).save(isA(StudentDTO.class));
        // act
        student.setStudentName("Juan P");
        studentService.update(student);
        // assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void deleteOk() {
        // arrange
        Long id = 1L;
        when(studentDAO.delete(id)).thenReturn(true);
        // act
        studentService.delete(id);
        // assert
        verify(studentDAO, atLeastOnce()).delete(id);
    }

    @Test
    void getAllOk() {
        // arrange
        Set<StudentDTO> expectedStudents = createStudentList();
        when(studentRepository.findAll()).thenReturn(expectedStudents);
        // act
        Set<StudentDTO> currentStudents = studentService.getAll();
        // assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(expectedStudents, currentStudents);
    }

    Set<StudentDTO> createStudentList() {
        return Set.of(
                new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D))),
                new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 8D), new SubjectDTO("Química", 4D)))
        );
    }
}
