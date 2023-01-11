package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class StudentRepositoryTest {

    private final StudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAllTest() {
        //Arrange
        int empty = 0;
        //Act
        Set <StudentDTO> actual = studentRepository.findAll();
        //Assert
        assertNotEquals(empty, actual.size());
    }
}
