package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO std1;
    private SubjectDTO sbj1, sbj2;

    @BeforeEach
    public void arrange() {
        sbj1 = new SubjectDTO("Chino", 3D);
        sbj2 = new SubjectDTO("Alemán", 5D);
        std1 = new StudentDTO(1L, "Alicia", null, null, List.of(sbj1, sbj2));
    }

    @Test
    public void registerStudentTest() {
        studentController.registerStudent(std1);
        verify(studentService, atLeastOnce()).create(std1);
    }

    @Test
    public void getStudentTest() {
        when(studentService.read(std1.getId())).thenReturn(std1);
        StudentDTO res = studentController.getStudent(std1.getId());

        verify(studentService, atLeastOnce()).read(std1.getId());
        assertEquals(std1, res);
    }

    @Test
    public void modifyStudentTest() {
        studentController.modifyStudent(std1);
        verify(studentService, atLeastOnce()).update(std1);
    }

    @Test
    public void removeStudentTest() {
        studentController.removeStudent(std1.getId());
        verify(studentService, atLeastOnce()).delete(std1.getId());
    }

    @Test
    public void listStudentsTest() {
        StudentDTO std2 = new StudentDTO(2L, "Benito", null, null, null );
        StudentDTO std3 = new StudentDTO(3L, "Camila", null, null, null );
        Set<StudentDTO> students = Set.of(std1, std2, std3);
        when(studentService.getAll()).thenReturn(students);

        Set<StudentDTO> res = studentController.listStudents();

        verify(studentService, atLeastOnce()).getAll();
        assertTrue(students.containsAll(res) && res.containsAll(students));
    }
}
