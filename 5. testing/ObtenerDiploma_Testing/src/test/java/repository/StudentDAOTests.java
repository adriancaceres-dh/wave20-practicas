package repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDAOTests {

    StudentDAO studentDAO = new StudentDAO();
    StudentDTO student = new StudentDTO();

    @Before
    public void loadTestData(){
        studentDAO.loadTestData();
    }

    @Test
    public void shouldFindStudent() {
        //arrange
        long validId = 1;
        //act
        StudentDTO result = studentDAO.findById(validId);
        //assert
        Assert.assertNotNull(result);
    }

    @Test(expected = StudentNotFoundException.class)
    public void shouldThrowExceptionIFStudentDoesNotExists() {
        //arrange
        long nonValidId = 0;
        //act
        studentDAO.findById(nonValidId);
    }

    @Test
    public void shouldExistAStudent() {
        //arrange
        student.setId(Long.valueOf(1));
        //act
        boolean result = studentDAO.exists(student);
        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void shouldNotExistAStudent() {
        //arrange
        student.setId(Long.valueOf(9));
        //act
        boolean result = studentDAO.exists(student);
        //assert
        Assert.assertFalse(result);
    }

    @Test
    public void shouldNotDeleteAStudent() {
        //arrange
        long nonValidId = 9;
        //act
        boolean result = studentDAO.delete(nonValidId);
        //assert
        Assert.assertFalse(result);
    }

    @Test
    public void shouldDeleteAStudent() {
        //arrange
        StudentDTO studentToDelete = new StudentDTO();
        //act
        studentDAO.save(studentToDelete);
        boolean result = studentDAO.delete(studentToDelete.getId());
        //assert
        Assert.assertTrue(result);
    }

    @Test
    public void shouldAddAStudentSuccessfully(){
        //arrange
        StudentDTO studentToAdd = new StudentDTO();
        //act
        studentDAO.save(studentToAdd);
        StudentDTO addedStudent= studentDAO.findById(studentToAdd.getId());
        //assert
        Assert.assertNotNull(addedStudent);
    }
    //podria catchear la excepcion

    @Test
    public void shouldModifyAStudentSuccessfully(){
        //arrange
        String originalName = "Matias";
        String modifiedName= "Armando";

        //act
        StudentDTO studentToModify =new StudentDTO(originalName);
        studentDAO.save(studentToModify);
        String studentToModifyName = studentDAO.findById(studentToModify.getId()).getStudentName();

        StudentDTO modifiedStudent = new StudentDTO(studentToModify.getId(), modifiedName);
        studentDAO.save(modifiedStudent);
        String modifiedStudentName = studentDAO.findById(modifiedStudent.getId()).getStudentName();

        //assert
        Assert.assertNotEquals(studentToModifyName, modifiedStudentName);
    }
}
