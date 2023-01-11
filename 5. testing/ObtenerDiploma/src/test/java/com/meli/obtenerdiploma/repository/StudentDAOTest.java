package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {
    StudentDAO studentDAO;
    SubjectDTO Maths;
    List<SubjectDTO> subjectDTOList;
    StudentDTO stu;

    @BeforeEach
    void setup(){
        studentDAO = new StudentDAO();
        List<SubjectDTO> subjectDTOList=new ArrayList<>();
        SubjectDTO Maths=new SubjectDTO("Matematicas",9.5);
        subjectDTOList.add(Maths);
        stu=new StudentDTO();

    }

    @Test
    void saveNewStudentOk(){
        //Arrange
        int actualSize=studentDAO.size();
        stu.setId(actualSize+1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);

        //Act
        studentDAO.save(stu);
        int result=studentDAO.size();
        //Assert
        Assertions.assertEquals(actualSize+1,result);

    }
    @Test
    void saveExistStudentOk(){
        //Arrange
        //create user
        int actualSize=studentDAO.size();
        stu.setId(actualSize+1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);
        //replace user
        actualSize=studentDAO.size();
        stu.setId((long)actualSize);
        stu.setStudentName("Camilo");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(6.0);
        //Act
        studentDAO.save(stu);
        int result=studentDAO.size();
        //Assert
        Assertions.assertEquals(actualSize,result);
    }
    @Test
    void deleteOk(){
        //Arrange
        int actualSize=studentDAO.size();
        stu.setId(actualSize+1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);
        Long id=actualSize+1L;
        studentDAO.save(stu);

        //Act
        boolean response=studentDAO.delete(id);

        //Assert
        Assertions.assertTrue(response);
    }
    @Test
    void deleteNotfoundId(){
        //Arrange
        Long id=-1L;

        //Act
        boolean response=studentDAO.delete(id);

        //Assert
        Assertions.assertFalse(response);
    }
    @Test
    void existOk(){
        //Arrange
        int actualSize=studentDAO.size();
        stu.setId(actualSize+1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);
        studentDAO.save(stu);
                //Act
        boolean response=studentDAO.exists(stu);

        //Assert
        Assertions.assertTrue(response);
    }
    @Test
    void notExist(){
        //Arrange

        stu.setId(-1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);

        //Act
        boolean response=studentDAO.exists(stu);

        //Assert
        Assertions.assertFalse(response);
    }
    @Test
    void findByIdOk(){
        //Arrange
        int actualSize=studentDAO.size();
        stu.setId(actualSize+1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);
        studentDAO.save(stu);

        //Act
        StudentDTO response=studentDAO.findById(actualSize+1L);

        //Assert
        Assertions.assertEquals(stu,response);
    }
    @Test
    void findByIdNotFoundHandlerException(){

        //Arrange
        Long id=-1L;

        //Act
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(id);
        });

        //Assert
        String expectedMessage = "El alumno con Id " + id + " no se encuetra registrado.";
        String actualMessage = exception.getError().getDescription();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
