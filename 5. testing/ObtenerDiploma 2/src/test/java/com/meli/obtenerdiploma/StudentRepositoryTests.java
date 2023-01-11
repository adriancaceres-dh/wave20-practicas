package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTests {
    StudentDAO studentDAO;
    StudentRepository studentRepository;

    public StudentRepositoryTests() {
        studentRepository = new StudentRepository();
        studentDAO = new StudentDAO();
    }

    @Test
    public void repositoryLoadsOK() {
        // Arrange
        int expectedStudents = 2;

        // Act
        int actual = studentRepository.findAll().size();

        // Assert
        assertEquals(expectedStudents, actual);
    }

}
