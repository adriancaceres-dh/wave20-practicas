package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

        StudentRepository studentRepository;

        public StudentRepositoryTest(){
            this.studentRepository = new StudentRepository();
        }

        @Test
        public void findAllNotEmptyTest() {
            //Arrange
            int empty = 0;
            //Act
            Set<StudentDTO> actual = studentRepository.findAll();
            //Assert
            Assertions.assertNotEquals(empty, actual.size());
        }

}


