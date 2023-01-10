package com.bootcamp.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.bootcamp.testing.dto.StudentResponseDto;
import com.bootcamp.testing.entity.Student;
import com.bootcamp.testing.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    List<Student> students;

    @BeforeEach // Preguntarle al profe
    void setup() {
        students = new ArrayList<>();
        students.add(new Student("1", "Dani1", 25));
        students.add(new Student("2", "Dani2", 25));
        students.add(new Student("3", "Diana", 50));
    }

    @Test
    @DisplayName("verificamos la cantidad de estudiantes")
    void testGetAllStudent() {
        // arrange
        int expected = 3;
        when(studentRepository.findAll()).thenReturn(students);

        // act
        List<StudentResponseDto> students = studentService.getAllStudent();
        int actual = students.size();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Aqui juegando a ser programador")
    void testFindById() {
        // arange
        String id = "3";
        Student student = new Student("3", "Diana", 50);
        StudentResponseDto expected = new StudentResponseDto(student);
        // act
        when(studentRepository.findById("3")).thenReturn(student);
        // assert
        assertEquals(expected, studentService.findById(id));
    }


}
