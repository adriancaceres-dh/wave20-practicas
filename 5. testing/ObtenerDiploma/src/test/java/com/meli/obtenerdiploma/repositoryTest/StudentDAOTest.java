package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    private final StudentDAO studentDAO = new StudentDAO();

    @Test
    void shouldSaveTest() {
        //Arrange
        StudentDTO student = dummyStudent();
        //Act
        studentDAO.save(student);
        //Assert
        assertNotNull(student.getId());
    }

    @Test
    void shouldFindByIdTest() {
        //Arrange
        Long id = 1L;
        //Act
        StudentDTO student = studentDAO.findById(id);
        //Assert
        assertNotNull(student);
    }

    @Test
    void shouldDeleteTest() {
        //Arrange
        Long id = 2L;
        //Act
        boolean response = studentDAO.delete(id);
        //Assert
        assertTrue(response);
    }

    private StudentDTO dummyStudent() {
        return new StudentDTO(null,
                "Anibal",
                null,
                null,
                List.of(new SubjectDTO("Quimica", 8D), new SubjectDTO("Algebra", 3D)));

    }
}
