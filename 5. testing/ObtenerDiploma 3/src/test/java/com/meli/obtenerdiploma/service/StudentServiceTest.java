package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    // dependencias
    @Mock
    private IStudentDAO mockStudentDAO;
    @Mock
    private StudentRepository mockStudentRepository;

    // este vamos a testear
    @InjectMocks
    private StudentService studentService;

    @Test
    void create() {
        //arrange
        StudentDTO student = new StudentDTO();
        //act
        studentService.create(student);
        //assert
        verify(mockStudentDAO, atLeast(1)).save(student);
    }

    @Test
    void readOk() {
        // arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Pepe");
        when(mockStudentDAO.findById(2L)).thenReturn(student);
        // act
        StudentDTO studentFound = studentService.read(2L);
        // assert
        assertEquals(student, studentFound);
    }

    @Test
    @DisplayName("Should thrown an exception when student not found")
    void readThrowsStudentNotFoundException() {
        // arrange
        when(mockStudentDAO.findById(1L)).thenThrow(StudentNotFoundException.class);
        // act

        // assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(1L));
    }

    @Test
    void update() {
        //arrange
        StudentDTO student = new StudentDTO();
        //act
        studentService.update(student);
        //assert
        verify(mockStudentDAO, atLeast(1)).save(student);
    }

    @Test
    void delete() {
        //act
        studentService.delete(1L);
        //assert
        verify(mockStudentDAO, atLeast(1)).delete(1L);
    }

    @Test
    void getAll() {
        // arrange
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO());
        students.add(new StudentDTO());
        when(mockStudentRepository.findAll()).thenReturn(students);
        // act
        Set<StudentDTO> studentsFound = studentService.getAll();
        //assert
        assertEquals(students, studentsFound);
    }

}