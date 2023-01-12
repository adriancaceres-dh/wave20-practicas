package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTests {

    private StudentDAO studentDAO;

    public StudentDAOTests(){
        studentDAO = new StudentDAO();
    }


    @Test
    @DisplayName("Guardando un estudiante") //Para esta prueba se requiere de mocks! (Método pasamanos)
    void saveStudentOK(){
        //Arrange
        boolean deleteExpected = true;
        StudentDTO stuInput  = new StudentDTO(2L, "Diego",null,null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        //Act


        //Assert

    }

    @Test
    @DisplayName("Chequeando si un usuario existe")
    void studentExistsOK() {
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Juan",null,null, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        //Act
        boolean result = studentDAO.exists(student);

        //Assert
        Assertions.assertTrue(result);
    }

}
