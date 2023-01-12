package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() {
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",9.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",7.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",6.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(3L,"Juan", null,null,subjectList);

        studentController.registerStudent(student);

        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    public void getStudent() {
        // arrange
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",9.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",7.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",6.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(1L,"Juan", null,null,subjectList);

        when(studentService.read(student.getId())).thenReturn(student);

        StudentDTO readStu = studentController.getStudent(student.getId());

        verify(studentService, atLeastOnce()).read(student.getId());
        assertEquals(student, readStu);
    }

    @Test
    public void modifyStudent() {
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",9.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",7.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",6.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(1L,"Adrian", null,null,subjectList);

        studentController.modifyStudent(student);

        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    public void removeStudent() {
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",9.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",7.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",6.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(1L,"Adrian", null,null,subjectList);


        studentController.removeStudent(1L);

        verify(studentService, atLeastOnce()).delete(1L);
    }

    @Test
    public void listStudents() {
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",9.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",7.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",6.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student1 = new StudentDTO(1L,"Juan", null,null,subjectList);

        SubjectDTO subjectTest4 = new SubjectDTO("Matemática",10.0);
        SubjectDTO subjectTest5 = new SubjectDTO("Física",8.0);
        SubjectDTO subjectTest6 = new SubjectDTO("Química",4.0);
        List<SubjectDTO> subjectList2 = Arrays.asList(subjectTest4,subjectTest5,subjectTest6);
        StudentDTO student2 = new StudentDTO(2L,"Pedro", null,null,subjectList2);

        Set<StudentDTO> studentsExpected = new HashSet<>();
        studentsExpected.add(student1);
        studentsExpected.add(student2);

        when(studentService.getAll()).thenReturn(studentsExpected);

        Set<StudentDTO> readStudents = studentController.listStudents();

        verify(studentService, atLeastOnce()).getAll();

        assertThat(readStudents).usingRecursiveComparison().isEqualTo(studentsExpected);

    }
}
