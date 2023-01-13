package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    private IStudentDAO studentDAO;
    private IStudentRepository studentRepository;

    public StudentRepositoryTest() {
        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }


    @Test
    void findAll() {
        //arrange
        //act
        Set<StudentDTO> studentDTOSetActual = studentRepository.findAll();
        //assert
        assertTrue(studentDTOSetActual.size() > 0);
    }

}