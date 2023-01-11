package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    private final StudentRepository studentRepository = new StudentRepository();

    @Test
    public void findAllTest() {
        //Arrange
        int expected = 2;
        //Act
        Set <StudentDTO> actual = studentRepository.findAll();
        //Assert
        Assertions.assertEquals(expected, actual.size());
    }
}
