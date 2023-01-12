package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    StudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;
    static StudentDTO student;
    @InjectMocks
    StudentService studentService;

    @BeforeAll
    static void setup() {
        SubjectDTO sub1 = new SubjectDTO("mate",10.0);
        SubjectDTO sub2 = new SubjectDTO("espa\u00F1ol",10.0);
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
        StudentDTO actual = studentService.read(4L);
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
        //arrange
        StudentDTO expected = student;
        when(studentDAO.findById(4L)).thenReturn(student);
        //act
        studentService.update(student);
        StudentDTO actual = studentService.read(4L);
        //assert
        verify(studentDAO, atLeast(1)).save(student);
        assertEquals(expected, actual);

    }

    @Test
    void delete() {
        //arrange
        StudentDTO studentToDelete = student;
        //act
        studentService.delete(studentToDelete.getId());
        //assert
        verify(studentDAO, atLeast(1)).delete(4L);
    }

    @Test
    void getAll() {
        //arrange
        Set<StudentDTO> expected = Set.of(student);
        when(studentRepository.findAll()).thenReturn(expected);
        //act
        Set<StudentDTO> actual =  studentService.getAll();
        //assert
        verify(studentRepository,atLeastOnce()).findAll();
        assertEquals(expected, actual);
    }
}