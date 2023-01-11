package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class StudentDAOTest {

    private IStudentDAO iStudentDAO= new StudentDAO();


/*    @Test
    public void deleteTestOk(){
        //Arrange
        boolean ok;
        //Act
        ok = iStudentDAO.delete(1L);
        //Assert
        Assertions.assertTrue(ok);
    }*/

    @Test
    public void deleteTestNotFound(){
        //Arrange
        boolean ok;
        //Act
        ok = iStudentDAO.delete(888L);
        //Assert
        Assertions.assertFalse(ok);
    }
    @Test
    public void deleteTestNull(){
        //Arrange
        boolean ok;
        //Act
        ok = iStudentDAO.delete(null);
        //Assert
        Assertions.assertFalse(ok);
    }

    @Test
    public void findTestOk(){
        //Arrange
        List<SubjectDTO> subjects= new ArrayList<>(){{
            add(new SubjectDTO("Matemática",10.0));
            add(new SubjectDTO("Física",8.0));
            add(new SubjectDTO("Química",4.0));
        }};
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null,subjects);
        //Act
        StudentDTO result = iStudentDAO.findById(2L);
        //Assert
        Assertions.assertEquals(result.getId(),expected.getId());
        Assertions.assertEquals(result.getStudentName(),expected.getStudentName());
        Assertions.assertEquals(subjects,expected.getSubjects());
    }

    @Test
    public void findTestNotFound(){
        //Arrange
        Long id = 3L;
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->iStudentDAO.findById(id));
    }

    @Test
    public void findTestNull(){
        //Arrange
        Long id =null;
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->iStudentDAO.findById(id));
    }

    @Test
    public void existTestOk(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L,null,null,null,null);
        boolean ok;
        //Act
        ok = iStudentDAO.exists(studentDTO);
        //Assert
        Assertions.assertTrue(ok);
    }

    @Test
    public void existTestNotFound(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(888L,null,null,null,null);
        boolean ok;
        //Act
        ok = iStudentDAO.exists(studentDTO);
        //Assert
        Assertions.assertFalse(ok);
    }

    @Test
    public void existTestNull(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(null,null,null,null,null);
        boolean ok;
        //Act
        ok = iStudentDAO.exists(studentDTO);
        //Assert
        Assertions.assertFalse(ok);
    }

    /*    @Test
        public void saveTestExistingOk(){
            //Arrange
            StudentDTO studentDTO = new StudentDTO(1L,"nombrePrueba",null,null,null);
            //Act
            iStudentDAO.save(studentDTO);
            //Assert
            Assertions.assertEquals(studentDTO.getStudentName(),iStudentDAO.findById(1L).getStudentName());
        }*/
/*    @Test
    public void saveTestNotExistingOk(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(888L,"nombrePrueba2",null,null,null);
        //Act
        iStudentDAO.save((studentDTO));
        //Assert
        Assertions.assertEquals(studentDTO.getStudentName(),iStudentDAO.findById((long) iStudentDAO.getStudentsSize()).getStudentName());
    }*/
    @Test
    public void saveTestNull(){
        //Arrange
        StudentDTO studentDTO = null;
        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class,()->iStudentDAO.save(studentDTO));
    }
/*    @Test
    public void saveTestNullAttributes(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(null,null,null,null,null);
        //Act
        int size = iStudentDAO.getStudentsSize()+1;
        iStudentDAO.save(studentDTO);
        //Assert
        Assertions.assertEquals(iStudentDAO.getStudentsSize(),size);
        Assertions.assertEquals(iStudentDAO.findById((long) size).getStudentName(), null);
    }*/
}

