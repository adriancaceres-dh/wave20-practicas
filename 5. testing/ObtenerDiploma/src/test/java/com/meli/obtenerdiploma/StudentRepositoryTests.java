package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTests {

    private IStudentRepository studentRepository;

    public StudentRepositoryTests(){
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Listar todos los alumnos")
    void findAllStudents() {
        //Arrange
        String json1 = "{\"id\":1,\"studentName\":\"Juan\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"Matemática\",\"score\":9.0},{\"name\":\"Física\",\"score\":7.0},{\"name\":\"Química\",\"score\":6.0}]}";
        String json2 = "{\"id\":2,\"studentName\":\"Pedro\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"Matemática\",\"score\":10.0},{\"name\":\"Física\",\"score\":8.0},{\"name\":\"Química\",\"score\":4.0}]}";
        ObjectMapper mapper = new ObjectMapper();
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO student1, student2;

        try {
            student1 = mapper.readValue(json1.getBytes(), StudentDTO.class);
            student2 = mapper.readValue(json2.getBytes(), StudentDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Set<StudentDTO> studentDTOS = mapper.readValue(json.getBytes(), Set<StudentDTO.class>);

        students.add(student1);
        students.add(student2);

        //Act
        Set<StudentDTO> studentsFound = studentRepository.findAll();

        //Assert: chequeo el tamaño de los Sets
        Assertions.assertEquals(students.size(), studentsFound.size());

    }

}
