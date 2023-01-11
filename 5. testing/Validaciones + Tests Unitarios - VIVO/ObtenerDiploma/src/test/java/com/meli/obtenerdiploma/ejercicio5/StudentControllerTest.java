package com.meli.obtenerdiploma.ejercicio5;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.util;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() {
        // arrange
        long studentID = 1L;
        StudentDTO studentDTO = util.getStudent(studentID, "Juan", util.getSubjects(false));

        // act
        studentController.registerStudent(studentDTO);

        // assert
        verify(studentService, atLeastOnce()).create(studentDTO);
    }

    @Test
    public void getStudent() {
        // arrange
        long studentID = 1L;
        StudentDTO studentDTO = util.getStudent(studentID, "Juan", util.getSubjects(false));
        when(studentService.read(studentID)).thenReturn(studentDTO);

        // act
        StudentDTO actual = studentController.getStudent(studentID);

        // assert
        verify(studentService, atLeastOnce()).read(studentID);
        Assertions.assertEquals(studentDTO, actual);
    }

    @Test
    public void modifyStudent() {
        // arrange
        long studentID = 1L;
        StudentDTO studentDTO = util.getStudent(studentID, "Juan", util.getSubjects(false));

        // act
        studentController.modifyStudent(studentDTO);

        // assert
        verify(studentService, atLeastOnce()).update(studentDTO);
    }

    @Test
    public void removeStudent() {
        // arrange
        long studentID = 1L;
        StudentDTO studentDTO = util.getStudent(studentID, "Juan", util.getSubjects(false));

        // act
        studentController.removeStudent(studentID);

        // assert
        verify(studentService, atLeastOnce()).delete(studentID);
    }

    @Test
    public void listStudents() {
        // arrange
        Set<StudentDTO> expectedStudent = new HashSet<>();

        List<SubjectDTO> subjects1 = util.getSubjects(false);
        StudentDTO studentDTO1 = util.getStudent(1L, "María", subjects1);
        expectedStudent.add(studentDTO1);

        List<SubjectDTO> subjects2 = util.getSubjects(false);
        StudentDTO studentDTO2 = util.getStudent(2L, "René", subjects2);
        expectedStudent.add(studentDTO2);

        List<SubjectDTO> subjects3 = util.getSubjects(false);
        StudentDTO studentDTO3 = util.getStudent(3L, "Tomas", subjects3);
        expectedStudent.add(studentDTO3);
        when(studentService.getAll()).thenReturn(expectedStudent);

        // act
        Set<StudentDTO> actualStudents = studentController.listStudents();

        // assert
        verify(studentService, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(expectedStudent, actualStudents));
    }
}
