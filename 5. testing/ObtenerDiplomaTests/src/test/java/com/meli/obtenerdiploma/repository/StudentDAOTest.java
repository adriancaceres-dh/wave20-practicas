package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    // https://martinfowler.com/bliki/GivenWhenThen.html
    StudentDAO studentDAO;
    StudentDTO studentDTO;
    List<SubjectDTO> validSubjects;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
        studentDTO = new StudentDTO();
        validSubjects = new ArrayList<>();
        populateValidSubjects();
    }

    void populateValidSubjects() {
        validSubjects.add(new SubjectDTO("Matemática", 5d));
        validSubjects.add(new SubjectDTO("Química", 6d));
        validSubjects.add(new SubjectDTO("Física", 9d));
    }

    @Test
    @DisplayName("Validate StudentDTO can be added")
    void Given_AStudentDTO_When_IsAdded_Then_ItIsPersisted() {

        studentDTO.setStudentName("Ezequiel");
        studentDTO.setSubjects(validSubjects);

        studentDAO.save(studentDTO);

        StudentDTO studentFound =  studentDAO.findById(3L);
        assertEquals("Ezequiel", studentFound.getStudentName());
        Assertions.assertIterableEquals(validSubjects, studentFound.getSubjects());

    }
}