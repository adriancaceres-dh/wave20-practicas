package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class StudentDAOTests {

    private IStudentDAO studentDAO;

    public StudentDAOTests(){
        studentDAO = new StudentDAO();
    }

    //Save
    @Test
    @DisplayName("Guardando un usuario")
    void saveStudentOK(){
        //Arrange: Creo un nuevo usuario y determino el largo del set que estoy evaluando (el esperado) en base al json
        StudentDTO student = new StudentDTO(3L, "Mario", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 6.0),
                new SubjectDTO("Química", 8.0)));
        int expectedSize = 3;
        studentDAO.save(student);

        //Act: Al ser un metodo void es difícil probar sin mock

        //Assert

    }

    //Delete
    @Test
    @DisplayName("Eliminando un usuario")
    void deleteStudentOK(){
        //Arrange
        long idTest = 3L; //En el caso de haber corrido el test anterior, probar con esto

        //Act
        boolean result = studentDAO.delete(idTest);

        //Assert
        Assertions.assertTrue(result);

    }

    //Exists
    @Test
    @DisplayName("Chequeando si un usuario existe")
    void studentExistsOK() {
        //Arrange: Pruebo con un usuario ya existente en el json.
        StudentDTO student = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        //Act
        boolean result = studentDAO.exists(student);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Chequeando que un usuario cualquiera no exista")
    void studentExistsNotOK() {
        //Arrange: Pruebo con un usuario con un ID que no se encuentra en el json.
        StudentDTO student = new StudentDTO(999L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        //Act
        boolean result = studentDAO.exists(student);

        //Assert
        Assertions.assertFalse(result);
    }

    //Find By Id
    @Test
    @DisplayName("Buscando por ID a un alumno")
    void findByIdOK() {
        //Arrange: ver la forma de que quede hardcodeado.
        long idTest = 2L;
        StudentDTO studentExpected =
                new StudentDTO(2L, "Pedro", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)));

        //Act
        StudentDTO studentResult = studentDAO.findById(idTest);

        //Assert
        Assertions.assertEquals(studentExpected.getStudentName(), studentResult.getStudentName());
    }

}
