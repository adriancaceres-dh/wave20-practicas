package com.meli.obtenerdiploma.RepositoriesTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();
    private StudentDTO studentDTOTest1 = new StudentDTO(0L, "Martin", "", 6.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
    private StudentDTO studentDTOTest2 = new StudentDTO(4L, "Emanuel", "", 7.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
    private StudentDTO studentDTOTest3DeUserJson = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),new SubjectDTO("Química",6.0)));

    /* En la BD hay objetos con ID: 4,3,2 y cuando agregue cualquiera sea, siempre va a
     * ser 4L. ¿Se puede modificar los valores de id que están en el JSON? ¿Debo ejecutar un
     * @beforeAll para cargar más datos y poder corroborar los datos?
     */
    @Test
    void saveAnUserNotSaved() {
        // arrange
        StudentDTO stu = new StudentDTO();
        stu.setStudentName("Emanuel");
        stu.setSubjects(List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));

        // act
        studentDAO.save(stu); // Tener cuidado porque escribe en el json y hay que eliminarlo luego.

        // assert
        assertTrue(studentDAO.exists(stu));
        assertEquals(3L, stu.getId());
        assertEquals(studentDAO.findById(stu.getId()), stu);
        studentDAO.delete(stu.getId());
    }

    @Test
    void saveAnUserSaved() {
        // Arrange
        Long expectedNewIdStudent = studentDTOTest3DeUserJson.getId();
        // Act
        studentDAO.save(studentDTOTest3DeUserJson);
        // Assert
        assertEquals(expectedNewIdStudent, studentDTOTest3DeUserJson.getId());
    }

    @Test
    void deleteAnUserNotExistingOnRepository() {
        // Arrange
        Long idTest = 15L;
        // Act
        boolean result = studentDAO.delete(idTest);
        // Assert
        assertFalse(result);
    }

    @Test
    void deleteAnUserExistingOnRepository() {
        // Arrange
        Long idTest = 2L; // Cuidado porque borra a Pedro
        // Act
        boolean result = studentDAO.delete(idTest);
        // Assert
        assertTrue(result);
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
        boolean result = studentDAO.exists(studentDTOTest3DeUserJson);
        // Assert
        assertTrue(result);
    }

    @Test
    void findUserNotExistingById() {
        // Arrange
        StudentNotFoundException expectedException = new StudentNotFoundException(1L);
        StudentNotFoundException result = null;
        // Act
        try {
            StudentDTO resultUser = studentDAO.findById(1L);
        } catch (StudentNotFoundException ex) {
            result = ex;
        }
        // Assert
        assertEquals(expectedException.getMessage(), result.getMessage());
    }

    @Disabled
    void findUserExistingById() {
        // Arrange
        StudentDTO userExpected = studentDTOTest3DeUserJson;
        // Act
        StudentDTO result = studentDAO.findById(4L);
        // Assert
        assertEquals(userExpected, result); // Me está comparando el espacio en memoria :(
    }
}