package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    private IStudentDAO studentDAO;

    public StudentDAOTest(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @Test
    void shouldSaveTest() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void shouldDeleteTest() {
        //Arrange
        Long id = 1L;
        //Act
        boolean response = studentDAO.delete(id);
        //Assert
        Assertions.assertEquals(true,response);
    }

    @Test
    void shouldExistTest() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void shouldFindByIdTest() {
        //Arrange
        //Act
        //Assert
    }



}
