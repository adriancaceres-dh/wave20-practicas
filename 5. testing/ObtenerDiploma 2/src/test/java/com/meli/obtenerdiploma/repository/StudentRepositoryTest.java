package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;


public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    public StudentRepositoryTest() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void shouldFindAllTest() {
        this.studentRepository.setSCOPE("main");
        //arrange
        int expected = 2;
        //act
        Set<StudentDTO> actual = studentRepository.findAll();
        //assert
        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    public void shouldFailFindAllTest() {
        this.studentRepository.setSCOPE(anyString());
        //arrange
        int expected = 0;
        //act
        Set<StudentDTO> actual = studentRepository.findAll();
        //assert
        Assertions.assertEquals(expected, actual.size());
    }

}
