package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.meli.obtenerdiploma.helper.StudentDTOHelper.dummyStudent;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    private final IStudentDAO studentDAO;

    @Autowired
    public StudentDAOTest(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Test
    void shouldSaveTest() {
        //Arrange
        StudentDTO student = dummyStudent();
        //Act
        studentDAO.save(student);
        //Assert
        assertNotNull(student.getId());

        studentDAO.delete(student.getId());
    }

    @Test
    void shouldFindByIdTest() {
        //Arrange
        StudentDTO student = dummyStudent();
        //Act
        studentDAO.save(student);
        StudentDTO foundStudent = studentDAO.findById(student.getId());
        //Assert
        assertNotNull(foundStudent);

        studentDAO.delete(student.getId());
    }

    @Test
    void shouldNotFindByIdTest() {
        //Arrange
        long invalidId = 0;
        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(invalidId));
    }

    @Test
    void shouldDeleteTest() {
        //Arrange
        StudentDTO student = dummyStudent();
        //Act
        studentDAO.save(student);
        boolean response = studentDAO.delete(student.getId());
        //Assert
        assertTrue(response);
    }
}
