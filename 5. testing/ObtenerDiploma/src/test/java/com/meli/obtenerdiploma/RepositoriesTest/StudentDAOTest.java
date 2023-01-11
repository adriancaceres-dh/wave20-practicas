package com.meli.obtenerdiploma.RepositoriesTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();
    private StudentDTO studentDTOTest1 = new StudentDTO(0L, "Martin", "", 6.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
    private StudentDTO studentDTOTest2 = new StudentDTO(2L, "Emanuel", "", 7.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));

    /* En la BD hay objetos con ID: 4,3,2 y cuando agregue cualquiera sea, siempre va a
    * ser 4L. ¿Se puede modificar los valores de id que están en el JSON? ¿Debo ejecutar un
    * @beforeAll para cargar más datos y poder corroborar los datos?
    */
    @Test
    void saveAnUserNotSaved() {
        // Arrange
        Long expectedNewIdStudent = 4L;
        // Act
        studentDAO.save(studentDTOTest1);
        // Assert
        assertEquals(expectedNewIdStudent,studentDTOTest1.getId());
    }
    @Test
    void saveAnUserSaved() {
        // Arrange
        Long expectedNewIdStudent = 4L;
        // Act
        studentDAO.save(studentDTOTest1);
        // Assert
        assertEquals(expectedNewIdStudent,studentDTOTest1.getId());
    }

    @Test
    void deleteAnUserNotExistingOnRepository() throws StudentNotFoundException {
        // Arrange
        Long idTest = studentDTOTest1.getId();
        // Act
        // Assert
        assertFalse(studentDAO.delete(idTest));

    }
    @Test
    void deleteAnUserExistingOnRepository() throws StudentNotFoundException{
        // Arrange
        Long idTest = 1L;
        // Act
        // Assert
        assertTrue(studentDAO.delete(idTest));
    }

    @Test
    void existAnUserExistingOnRepository() {
        // Arrange
        // Act
        // Assert
        assertFalse(studentDAO.exists(studentDTOTest1));
    }
    @Test
    void existAnUserNotExistingOnRepository() {
        // Arrange
        // Act
        // Assert
        studentDAO.exists(studentDTOTest2);
        assertTrue(studentDAO.exists(studentDTOTest2));
    }

    @Test
    void findUserNotExistingById() {
        // Arrange
        studentDAO.save(studentDTOTest1);
        StudentDTO expectedUser = studentDTOTest1;
        // Act
        StudentDTO resultUser = studentDAO.findById(4L);
        // Assert
        assertEquals(expectedUser,resultUser); // Me está comparando el espacio en memoria :(
    }
}