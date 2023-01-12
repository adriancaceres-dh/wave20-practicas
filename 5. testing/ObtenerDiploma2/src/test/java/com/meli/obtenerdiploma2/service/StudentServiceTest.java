package com.meli.obtenerdiploma2.service;

import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.repository.IStudentDAO;
import com.meli.obtenerdiploma2.repository.IStudentRepository;
import com.meli.obtenerdiploma2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO dao ;
    @Mock
    IStudentRepository repo;

    @InjectMocks
    StudentService service;

    @Test
    void create() {
        //Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects();
        //Act
        service.create(student);
        //Assert
        verify(dao, atLeastOnce()).save(student);
    }

    @Test
    void read() {
        //Arrange
        StudentDTO expectedStudent = TestUtilsGenerator.getStudentWith3Subjects();
        when(dao.findById(expectedStudent.getId())).thenReturn(expectedStudent);
        //Act
        StudentDTO actualStudent =  service.read(expectedStudent.getId());
        //Assert
        verify(dao, atLeastOnce()).findById(expectedStudent.getId());
        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    void update() {
        //Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects();
        //Act
        service.update(student);
        //Assert
        verify(dao, atLeastOnce()).save(student);
    }

    @Test
    void delete() {
        //Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects();
        //Act
        service.delete(student.getId());
        //Assert
        verify(dao, atLeastOnce()).delete(student.getId());
    }

    @Test
    void getAll() {
        //Arrange
        Set<StudentDTO> expectedStudentList = TestUtilsGenerator.getStudentsList();
        when(repo.findAll()).thenReturn(expectedStudentList);
        //Act
        Set<StudentDTO> actualStudentList = service.getAll();
        //Assert
        assertEquals(expectedStudentList, actualStudentList);
    }
}