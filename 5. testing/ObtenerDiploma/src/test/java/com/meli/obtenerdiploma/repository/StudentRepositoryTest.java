package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private final StudentRepository studentRepository;
    public StudentRepositoryTest(){
        this.studentRepository = new StudentRepository();
    }

    @Test
    void testListAllStudents(){
        Set<StudentDTO> studentDTOSet=studentRepository.findAll();
        assertTrue(studentDTOSet.size()>0);
    }

}