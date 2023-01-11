package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StudentDaoTest {

    StudentDAO studentDAO;

    public StudentDaoTest() {
        this.studentDAO = new StudentDAO();
    }

    @BeforeEach
    public void loadData(){
        studentDAO.loadDataTest();
    }

    //findById
    @Test
    @DisplayName("should find user with id 1")
    public void findByIdTest_shutFindTheUserWithId1(){
        //Arrange
        StudentDTO studentDTO_expected = new StudentDTO();
        studentDTO_expected.setId(1L);
        studentDTO_expected.setStudentName("Juan");
        studentDTO_expected.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)
        )));

        StudentDTO studentDTO_actual;

        //Act

        studentDTO_actual = studentDAO.findById(1L);

        //Assert

        Assertions.assertEquals(studentDTO_expected,studentDTO_actual);

    }

    @Test()
    @DisplayName("should Throw an UserNotFoundException")
    public void findByIdExceptionTest_shutThrowUsertNotFoundException(){
        //Arrange
        Long id = 0L;

        //Act and Assert
         StudentNotFoundException studentNotFoundException = Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(id);});
    }

    //delete
    @Test
    @DisplayName("should delete a student")
    public void deleteTestShouldDeleteAStudent(){
        //arrange
        long id = 1;
        boolean expected = true;
        boolean actual;
        //act
        actual = studentDAO.delete(id);
        //Assert
        Assertions.assertEquals(expected,actual);

    }

    @Test
    @DisplayName("should not delete a student")
    public void deleteTestShouldNotDeleteAStudent(){
        //arrange
        long id = 0;
        boolean expected = false;
        boolean actual;
        //act
        actual = studentDAO.delete(id);
        //Assert
        Assertions.assertEquals(expected,actual);

    }

    //exist
    @Test
    @DisplayName("Should show that the student exists")
    public void existsTestExist(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)
        )));

        boolean expected = true;
        boolean actual;

        //act
        actual = studentDAO.exists(studentDTO);

        //Assert
        Assertions.assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Should show that the student not exists")
    public void existsTestNotExist(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)
        )));

        boolean expected = false;
        boolean actual;

        //act
        actual = studentDAO.exists(studentDTO);

        //Assert
        Assertions.assertEquals(expected,actual);

    }

    //save
    @Test
    @DisplayName("should save a student")
    public void saveTestShouldSaveAStudent(){
        //Assert
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(3L);
        studentDTO1.setStudentName("Juan");
        studentDTO1.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)
        )));

        boolean expected = true;
        boolean actual;
        //Act
        studentDAO.save(studentDTO1);
        actual = studentDAO.exists(studentDTO1);
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("should modify a student")
    public void saveTestShouldModifyAStudent(){
        //Assert
        StudentDTO studentDTO_expected = new StudentDTO();
        studentDTO_expected.setId(2L);
        studentDTO_expected.setStudentName("Bernardo");
        studentDTO_expected.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)
        )));

        StudentDTO studentDTO_actual;

        //Act
        studentDAO.save(studentDTO_expected);
        studentDTO_actual = studentDAO.findById(studentDTO_expected.getId());

        //Assert
        Assertions.assertEquals(studentDTO_expected,studentDTO_actual);
    }
}
