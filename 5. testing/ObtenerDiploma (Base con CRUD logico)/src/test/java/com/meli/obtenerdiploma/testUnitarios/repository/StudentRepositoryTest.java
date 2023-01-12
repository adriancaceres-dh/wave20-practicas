package com.meli.obtenerdiploma.testUnitarios.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();

    @Test
    @DisplayName("Retornar el set de estudiantes que vienen en el Json")
    void findAllOK() throws IOException {
        //Arrange
        Set<StudentDTO> expectedlLoadedData = new HashSet<>();
        File file = ResourceUtils.getFile("./src/test/resources/users.json");
        ObjectMapper objectMapper = new ObjectMapper();
        expectedlLoadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});

        //Act
        Set<StudentDTO> actualLoadedData = studentRepository.findAll();
        //Assert
        Assertions.assertEquals(expectedlLoadedData,actualLoadedData);
        Assertions.assertEquals(expectedlLoadedData.size(),2);

    }

    @Test
    @DisplayName("Retornar el set de estudiantes que vienen en el Json, pero con error de lectura por " +
            "nombre de json distinto")
    void findAllNotOK() throws IOException {
        //Arrange
        Set<StudentDTO> expectedStudentDTO = new HashSet<>();
        //Act
        Set<StudentDTO> actualStudentDTO = studentRepository.findAll();
        //Assert
        Assertions.assertEquals(expectedStudentDTO,actualStudentDTO);
    }





}
