package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTests {

    private IStudentRepository studentRepository;

    public StudentRepositoryTests(){
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Camino feliz - Debería listar todos los alumnos")
    void findAllStudents() {
        //Arrange
        String json = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 9\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 7\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 6\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"studentName\": \"Pedro\",\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 10\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 8\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 4\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        Set<StudentDTO> students;

        //Set<StudentDTO> studentDTOS = mapper.readValue(json.getBytes(), Set<StudentDTO.class>);
        try {
            students = mapper.readValue(json, new TypeReference<Set<StudentDTO>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Act
        Set<StudentDTO> studentsFound = studentRepository.findAll();

        //Assert
        Assertions.assertEquals(students, studentsFound);

    }

}
