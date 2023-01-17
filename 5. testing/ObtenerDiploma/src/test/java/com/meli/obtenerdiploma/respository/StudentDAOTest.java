package com.meli.obtenerdiploma.respository;

import com.meli.obtenerdiploma.TestUtilsGenerator;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;


public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void studentSaveTestOK() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void studentDeleteTestOK() {
        /// arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void studentDeleteTestException() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void verifyExistentStudentTest() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        boolean result = studentDAO.exists(stu);

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    public void verifyNonExistentStudentTest() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        boolean result = studentDAO.exists(stu);

        // assert
        Assertions.assertFalse(result);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void modifyNonExistentStudentTest() {
        // arrange
        StudentDTO stu1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        StudentDTO stu2 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu2.setId(999L);
        stu2.setStudentName("Marco Polo");

        studentDAO.save(stu1);

        // act
        studentDAO.save(stu2);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu1));
        Assertions.assertEquals(1L, stu1.getId());
        Assertions.assertEquals(studentDAO.findById(stu1.getId()), stu1);

        Assertions.assertTrue(studentDAO.exists(stu2));
        Assertions.assertEquals(2L, stu2.getId());
        Assertions.assertEquals(studentDAO.findById(stu2.getId()), stu2);

    }

    @Test
    public void modifyExistentStudentTest() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        stu.setStudentName("Marco Polo");
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void findExistentStudentTest() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        StudentDTO found = studentDAO.findById(stu.getId());

        // assert
        Assertions.assertEquals(found, stu);
    }

    @Test
    public void findNonExistentStudentTest() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }
}
