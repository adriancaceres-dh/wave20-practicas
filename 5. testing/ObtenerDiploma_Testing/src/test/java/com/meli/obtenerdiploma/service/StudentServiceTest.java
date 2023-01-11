package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void whenCreateAStudentThenVerifyItSuccesfully() {
        //Arrange
        StudentDTO createdStudent = createStudent(9d, 8d);
        //Act
        studentService.create(createdStudent);
        //Assert
        verify(studentDAO, atLeastOnce()).save(createdStudent);
    }

    @Test
    public void whenReadAStudentThenVerifyItSuccesfully() {
        //Arrange
        long id = 1L;
        StudentDTO expectedStudent = createStudent(8d, 9d);
        when(studentDAO.findById(id)).thenReturn(expectedStudent);
        //Act
        StudentDTO studentToCompare = studentService.read(id);
        //Assert
        verify(studentDAO, atLeastOnce()).findById(id);
        assertEquals(expectedStudent, studentToCompare);
    }

    @Test
    public void whenUpdateAStudentThenVerifyItSuccesfully() {
        // arrange
        StudentDTO student = createStudent(8d, 9d);
        // act
        studentService.update(student);
        // assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    public void whenDeleteAStudentThenVerifyItSuccesfully() {
        // arrange
        StudentDTO student = createStudent(8d, 9d);
        // act
        studentService.delete(student.getId());
        // assert
        verify(studentDAO, atLeastOnce()).delete(student.getId());
    }

    private StudentDTO createStudent(double score1, double score2) {

        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", score1));
        subjects.add(new SubjectDTO("Literature", score2));
        student.setSubjects(subjects);

        return student;
    }
}