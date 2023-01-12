package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;
    static StudentDTO student;
    @InjectMocks
    StudentService studentService;

    @BeforeAll
    static void setup() {
        SubjectDTO sub1 = new SubjectDTO("mate",10.0);
        SubjectDTO sub2 = new SubjectDTO("español",10.0);
        List<SubjectDTO> subjects = Arrays.asList(sub1,sub2);
        student = new StudentDTO(4L,"Alberto","", (double) 0,subjects);
    }
    @Test
    @DisplayName("Create camino feliz")
    void createOKTest() {
        //arrange
        StudentDTO expected = student;
        //act
        studentService.create(student);
        when(studentDAO.findById(4L)).thenReturn(student);
        StudentDTO actual = studentService.read(expected.getId());
        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Read camino feliz")
    void readOKTest() {
        //arrange
        StudentDTO expected = student;
        //act
        when(studentDAO.findById(4L)).thenReturn(student);
        StudentDTO actual = studentService.read(4L);
        //assert
        assertEquals(expected,actual);
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}