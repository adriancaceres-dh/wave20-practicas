package com.meli.obtenerdiplomatests.repository;

import com.meli.obtenerdiplomatests.exception.StudentNotFoundException;
import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.util.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class StudentDAOTests {
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void init(){
        TestUtils.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void findByIdNotFoundTest(){
        // arrange
        Long idToFind = 99L;
        // act && assert
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(idToFind));
    }
    @Test
    public void findByIdFoundTest(){
        // arrange
        Long idToFind = 2L;
        StudentDTO studentExpected = TestUtils.getStudentId2();
        // act
        StudentDTO result = studentDAO.findById(idToFind);
        // assert
        Assertions.assertEquals(studentExpected, result);
    }

    @Test
    public void saveSuccesTest(){
        StudentDTO studentToSave = TestUtils.getStudentToSave();
        StudentDTO expectedStudentDTO = TestUtils.getStudentToSave();

        studentDAO.save(studentToSave);
        StudentDTO result = studentDAO.findById(expectedStudentDTO.getId());

        Assertions.assertEquals(expectedStudentDTO, result);
    }
}
