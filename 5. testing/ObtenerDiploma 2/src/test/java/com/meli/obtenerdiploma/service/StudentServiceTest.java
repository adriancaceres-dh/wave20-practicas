package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.helper.StudentHelperTest;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO student;

    @BeforeEach
    public void init() {
        this.student = StudentHelperTest.getStudentWithBadScore("Pedro");
    }

    @Test
    public void shouldRead() {
        //arrange
        Long id = 1L;
        StudentDTO expected = StudentDTO.builder().build();
        when(studentDAO.findById(anyLong())).thenReturn(expected);
        //act
        StudentDTO actual = this.studentService.read(id);
        //assertion
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {
        //arrange
        Set<StudentDTO> expected = new HashSet<StudentDTO>();
        expected.add(new StudentDTO());
        expected.add(new StudentDTO());
        when(studentRepository.findAll()).thenReturn(expected);
        //act
        Set<StudentDTO> actual = this.studentService.getAll();
        //assertion
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreate() {
        //arrange
        StudentDTO expected = this.student;

        //act
        studentService.create(expected);

        //assert
        verify(studentDAO, atLeastOnce()).save(expected);
    }

    @Test
    public void shouldUpdate() {
        //arrange
        StudentDTO mockStudent = this.student;

        //act
        studentService.update(mockStudent);

        //assert
        verify(studentDAO, atLeastOnce()).save(mockStudent);
    }

    @Test
    public void shouldDelete() {
        //arrange
        Long mockStudentId = this.student.getId();

        //act
        studentService.delete(mockStudentId);

        //assert
        verify(studentDAO, atLeastOnce()).delete(mockStudentId);
    }
}
