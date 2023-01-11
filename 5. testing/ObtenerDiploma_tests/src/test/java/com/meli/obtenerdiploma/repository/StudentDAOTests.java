package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.parameter_resolver.StudentDAOParameterResolver;
import com.meli.obtenerdiploma.util.TestsUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(StudentDAOParameterResolver.class)
public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    public void setUp() {
        try {
            TestsUtilsGenerator.resetUsersFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.studentDAO = new StudentDAO();
    }

    @Test
    void saveNonExistent() {
        // arrange
        Long id = 100L;
        StudentDTO expected = new StudentDTO(id, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        // act
        studentDAO.save(expected);
        // assert
        assertTrue(studentDAO.exists(expected));
        assertEquals(expected, studentDAO.findById(expected.getId()));
        assertNotEquals(id, expected.getId()); // The id is automatically assigned when the student doesn't exist
    }

    @Test
    void saveExistent() {
        // arrange
        Long id = 2L;
        StudentDTO expected = new StudentDTO(id, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 8D), new SubjectDTO("Química", 4D)));
        // act
        studentDAO.save(expected);
        // assert
        assertTrue(studentDAO.exists(expected));
        assertEquals(expected, studentDAO.findById(expected.getId()));
        assertEquals(id, expected.getId()); // The id is the same when the student exists
    }

    @Test
    void modifyExistent() {
        // arrange
        Long id = 2L;
        StudentDTO expected = studentDAO.findById(id);
        // act
        expected.setStudentName("Luis");
        studentDAO.save(expected);
        // assert
        assertTrue(studentDAO.exists(expected));
        assertEquals(id, expected.getId());
        assertEquals(expected, studentDAO.findById(id));
    }

    @Test
    void modifyNonExistent() {
        // arrange
        Long id = 2L;
        Long newId = 30L;
        StudentDTO existent = studentDAO.findById(id);
        StudentDTO expected = new StudentDTO(newId, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 8D), new SubjectDTO("Química", 4D)));
        // act
        expected.setStudentName("Luis");
        studentDAO.save(expected); // Creates the student because it doesn't exist
        // assert
        assertTrue(studentDAO.exists(expected));
        assertNotEquals(existent, studentDAO.findById(expected.getId()));
        assertNotEquals(newId, expected.getId()); // The id is automatically assigned when the student doesn't exist
    }

    @Test
    void deleteExistent() {
        // arrange
        Long id = 2L;
        // act
        boolean deleted = studentDAO.delete(id);
        // assert
        assertTrue(deleted);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    void deleteNonExistent() {
        // arrange
        Long id = 30L;
        // act
        boolean deleted = studentDAO.delete(id);
        // assert
        assertFalse(deleted);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    void existsTrue() {
        // arrange
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));
        // act
        boolean exists = studentDAO.exists(expected);
        // assert
        assertTrue(exists);
        assertDoesNotThrow(() -> studentDAO.findById(id));
    }

    @Test
    void existsFalse() {
        // arrange
        Long id = 30L;
        StudentDTO student = new StudentDTO(id, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));
        // act
        boolean exists = studentDAO.exists(student);
        // assert
        assertFalse(exists);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    void findByIdOk() {
        // arrange
        Long id = 1L;
        // act
        StudentDTO student = studentDAO.findById(id);
        // assert
        assertNotNull(student);
        assertDoesNotThrow(() -> studentDAO.findById(id));
    }

    @Test
    void findByIdException() {
        // arrange
        Long id = 20L;
        // act
        Executable executable = () -> studentDAO.findById(id);
        // assert
        assertThrows(StudentNotFoundException.class, executable);
    }
}
