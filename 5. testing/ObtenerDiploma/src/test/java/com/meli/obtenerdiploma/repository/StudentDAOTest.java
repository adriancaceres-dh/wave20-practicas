package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private final StudentDAO studentDAO;
    public StudentDAOTest(){
        this.studentDAO = new StudentDAO();
    }

    @Test
    void testCheckNewStudent(){

        List< SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO stu = new StudentDTO(1231L,"Camilo","Buen estudiante"
                , 4.0, subjectsDTOS );

        studentDAO.save(stu);
        assertTrue(studentDAO.exists(stu));
    }

    @Test
    void testFindStudentById(){
        //Arrange
        List< SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO stu = new StudentDTO(1231L,"Camilo","Buen estudiante"
                , 4.0, subjectsDTOS );

        //Action
        studentDAO.save(stu);
        StudentDTO studentFound = studentDAO.findById(stu.getId());
        //Asserts
        assertNotNull(studentFound);
        assertEquals(studentFound.getId(),stu.getId());
    }
    @Test
    void testModifyStudent(){
        //Arrange
        List< SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        //Action
        studentDAO.save(new StudentDTO(1L,"Andres",null,3.4,subjectsDTOS));
        //Asserts
        assertEquals("Andres",studentDAO.findById(1L).getStudentName());
    }

    @Test
    void deleteStudent(){
        //Arrange
        long queryId = 9L;
        //Action
        boolean result =studentDAO.delete(queryId);
        //Assert
        assertTrue(result);
    }

}