package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StudentDAOTest {
    private final StudentDAO studentDAO;
    private List<SubjectDTO> subjectDTOList;
    private StudentDTO studentDTO;

    public StudentDAOTest() {
        this.studentDAO = new StudentDAO();

        subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths",4.0) );
        subjectDTOList.add(new SubjectDTO("History",4.5) );
        studentDTO = new StudentDTO(1231L,"Camilo","Buen estudiante"
                , 4.0, subjectDTOList );
    }


    @Test
    void testSaveEstudent(){
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }


    @Test
    void testFindStudentById(){
        studentDAO.save(studentDTO);
        StudentDTO student = studentDAO.findById(studentDTO.getId());

        assertNotNull(student);
        assertEquals(student.getId(),studentDTO.getId());
    }
    @Test
    void testModifyStudent(){

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths",4.0) );
        subjectDTOList.add(new SubjectDTO("History",4.5) );

        studentDAO.save(new StudentDTO(1L,"Andres",null,3.4,subjectDTOList));

        assertEquals("Andres",studentDAO.findById(1L).getStudentName());
    }

    @Test
    void deleteStudent(){
        long queryId = 6L;

        boolean result = studentDAO.delete(queryId);

        assertTrue(result);
    }


}
