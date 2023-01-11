package com.meli.obtenerdiploma.repositoryTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {


    private Set<StudentDTO> students = new HashSet<>();

    private IStudentRepository studentRepository = new StudentRepository();

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "main");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/users.json");
            students = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        //Arrange
        int expected= students.size();
        //Act
        int received= studentRepository.findAll().size();
        //Assert
        Assertions.assertEquals(expected, received);
    }

}
