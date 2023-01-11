package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    void registerStudent()  {
        List<SubjectDTO> subjects = getSubjects(
                "Química",
                10d,
                "Física",
                8d
        );
        StudentDTO student = getStudent("Esteban", subjects);
        doNothing().when(studentService).create(student);

        ResponseEntity<?> response = studentController.registerStudent(student);

        verify(studentService,atLeast(1)).create(student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getStudent() {
        List<SubjectDTO> subjects = getSubjects(
                "Química",
                10d,
                "Física",
                8d
        );
        StudentDTO student = getStudent("Esteban", subjects);
        when(studentService.read(1L)).thenReturn(student);

        StudentDTO response = studentController.getStudent(1L);
        verify(studentService, atLeast(1)).read(1L);
        assertEquals(student, response);
    }

    @Test
    void modifyStudent() {
        List<SubjectDTO> subjects = getSubjects(
                "Química",
                10d,
                "Física",
                8d
        );
        StudentDTO student = getStudent("Esteban", subjects);
        doNothing().when(studentService).update(student);

        ResponseEntity<?> response = studentController.modifyStudent(student);

        verify(studentService, atLeast(1)).update(student);
        assertNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void removeStudent() {
        List<SubjectDTO> subjects = getSubjects(
                "Química",
                10d,
                "Física",
                8d
        );
        StudentDTO student = getStudent("Esteban", subjects);
        doNothing().when(studentService).delete(1L);

        ResponseEntity<?> response = studentController.removeStudent(1L);

        verify(studentService, atLeast(1)).delete(1L);
        assertNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void listStudents() {
        List<SubjectDTO> subjects = getSubjects(
                "Química",
                10d,
                "Física",
                8d
        );
        StudentDTO student = getStudent("Esteban", subjects);
        Set<StudentDTO> studentSet = new HashSet<>();
        studentSet.add(student);
        when(studentService.getAll()).thenReturn(studentSet);

        Set<StudentDTO> studentsRetrieved = studentController.listStudents();

        verify(studentService, atLeast(1)).getAll();
        assertEquals(studentSet, studentsRetrieved);
    }

    private StudentDTO getStudent(String studentName, List<SubjectDTO> subjects) {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName(studentName);
        student.setSubjects(subjects);
        return student;
    }

    private List<SubjectDTO> getSubjects(
            String subjectName1,
            double scoreSubject1,
            String subjectName2,
            double scoreSubject2
    ) {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO(subjectName1, scoreSubject1));
        subjects.add(new SubjectDTO(subjectName2, scoreSubject2));
        return subjects;
    }
}

