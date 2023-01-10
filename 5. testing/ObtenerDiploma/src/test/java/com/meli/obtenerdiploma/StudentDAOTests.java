package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTests {

    private StudentDAO studentDAO;

    public StudentDAOTests(){
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Chequeando si un usuario existe")
    void studentExistsOK() {
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        //Act
        boolean result = studentDAO.exists(student);

        //Assert
        Assertions.assertTrue(result);
    }

}
