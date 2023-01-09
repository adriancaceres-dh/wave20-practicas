package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Add a new student")
    void addNewStudentTest() {
        StudentDTO newStudent = getStudent();
        doAnswer((i) -> null).when(studentDAO).save(newStudent);

        studentService.create(newStudent);
        verify(studentDAO, atLeast(1)).save(newStudent);
    }

    @Test
    @DisplayName("Update student")
    void updateStudentTest() {
        StudentDTO updatedStudent = getStudent();
        doAnswer((i) -> null).when(studentDAO).save(updatedStudent);

        studentService.update(updatedStudent);
        verify(studentDAO, atLeast(1)).save(updatedStudent);
    }

    @Test
    @DisplayName("Delete existent student")
    void deleteExistentStudentTest() {
        when(studentDAO.delete(1L)).thenReturn(true);

        studentService.delete(1L);
        verify(studentDAO, atLeast(1)).delete(1L);
    }

    @Test
    @DisplayName("Delete non-existent student")
    void deleteNonExistentStudentTest() {
        when(studentDAO.delete(111L)).thenReturn(false);

        studentService.delete(111L);
        verify(studentDAO, atLeast(1)).delete(111L);
    }

    @Test
    @DisplayName("Read an existing student")
    void readExistingStudent() {
        StudentDTO student = getStudent();
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO studentFound = studentService.read(1L);

        verify(studentDAO, atLeast(1)).findById(1L);
        assertEquals(student, studentFound);
    }

    @Test
    @DisplayName("Get all students")
    void getAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(getStudent());
        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> studentsRetrieved = studentService.getAll();

        verify(studentRepository, atLeast(1)).findAll();
        assertEquals(students, studentsRetrieved);
    }

    private StudentDTO getStudent() {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(1L);
        newStudent.setStudentName("Pedro");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Física", 9d));
        subjects.add(new SubjectDTO("Historia", 3d));
        newStudent.setSubjects(subjects);
        return newStudent;
    }


}