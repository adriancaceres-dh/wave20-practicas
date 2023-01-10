package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    private IStudentRepository studentRepository;

    public StudentRepositoryTest(IStudentRepository studentRepository){
            this.studentRepository = studentRepository;
    }

    @Test
    public void findAllTest() {
        //arrange
        int expected = 2;

        //act
        Set < StudentDTO > actual = studentRepository.findAll();

        //assert
        Assertions.assertEquals(expected, actual.size());
    }


}
