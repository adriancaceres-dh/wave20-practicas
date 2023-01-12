package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.helper.StudentHelperTest;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

  @Test
    public void shouldRegisterStudent() {
        //arrange
        StudentDTO student = StudentHelperTest.getStudentWithBadScore("Pedro");
        //act
        studentController.registerStudent(student);
        //assert
        verify(studentService, atLeastOnce()).create(student);
    }
    @Test
    public void shouldGetStudent() {
        //arrange
        StudentDTO expected = StudentHelperTest.getStudentWithBadScore("Pedro");
        when(studentService.read(expected.getId())).thenReturn(expected);
        //act
        StudentDTO actual = studentController.getStudent(expected.getId());
        //assert
        verify(studentService, atLeastOnce()).read(expected.getId());
        assertEquals(expected, actual);

    }

    @Test
    public void shouldModifyStudent() {
        //arrange
        StudentDTO student = StudentHelperTest.getStudentWithBadScore("Pedro");
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        //act
        ResponseEntity actual = studentController.modifyStudent(student);
        //assert
        verify(studentService, atLeastOnce()).update(student);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveStudent() {
        //arrange
        StudentDTO student = StudentHelperTest.getStudentWithBadScore("Pedro");
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        //act
        ResponseEntity actual = studentController.removeStudent(student.getId());
        //assert
        verify(studentService, atLeastOnce()).delete(student.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldListStudents() {
        //arrange
        Set<StudentDTO> expected = StudentHelperTest.getStudentSet();
        when(studentService.getAll()).thenReturn(expected);
        //act
        Set<StudentDTO> actual = studentController.listStudents();
        //assert
        verify(studentService, atLeastOnce()).getAll();
        assertEquals(expected, actual);
    }
}
