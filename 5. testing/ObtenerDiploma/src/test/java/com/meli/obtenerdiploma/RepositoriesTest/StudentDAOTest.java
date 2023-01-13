package com.meli.obtenerdiploma.RepositoriesTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();
    private StudentDTO studentDTOTest1 = new StudentDTO(0L, "Martin", "", 6.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
    private StudentDTO studentDTOTest3DeUserJuan = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),new SubjectDTO("Química",6.0)));
    private StudentDTO studentDTOTest3DeUserPedro = new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0),new SubjectDTO("Química",4.0)));

    @Test
    void saveAnUserNotSaved() {
        // arrange
        StudentDTO stu = new StudentDTO();
        stu.setStudentName("Emanuel");
        stu.setSubjects(List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));

        // act
        studentDAO.save(stu); // Tener cuidado porque escribe en el json y hay que eliminarlo luego.

        // assert
        assertTrue(studentDAO.exists(stu));
        assertEquals(3L, stu.getId());
        assertEquals(studentDAO.findById(stu.getId()), stu);
        studentDAO.delete(stu.getId());
    }

    @Test
    void saveAnUserSaved() {
        // Arrange
        Long expectedNewIdStudent = studentDTOTest3DeUserJuan.getId();
        // Act
        studentDAO.save(studentDTOTest3DeUserJuan);
        // Assert
        assertEquals(expectedNewIdStudent, studentDTOTest3DeUserJuan.getId());
    }

    @Test
    void deleteAnUserNotExistingOnRepository() {
        // Arrange
        Long idTest = 15L;
        // Act
        boolean result = studentDAO.delete(idTest);
        // Assert
        assertFalse(result);
    }

    @Test
    void deleteAnUserExistingOnRepository() {
        // Arrange
        Long idTest = 2L; // Cuidado porque borra a Pedro
        // Act
        boolean result = studentDAO.delete(idTest);
        // Assert
        assertTrue(result);
        studentDAO.save(studentDTOTest3DeUserPedro); // Vuelvo a agregarlo
    }

    @Test
    void existAnUserExistingOnRepository() {
        // Arrange
        // Act
        // Assert
        assertFalse(studentDAO.exists(studentDTOTest1));
    }

    @Test
    void existAnUserNotExistingOnRepository() {
        // Arrange
        // Act
        boolean result = studentDAO.exists(studentDTOTest1);
        // Assert
        assertFalse(result);
    }

    @Test
    void findUserNotExistingById() {
        // Arrange
        StudentNotFoundException expectedException = new StudentNotFoundException(1L);
        StudentNotFoundException result = null;
        // Act
        try {
            StudentDTO resultUser = studentDAO.findById(5L);
        } catch (StudentNotFoundException ex) {
            result = ex;
        }
        // Assert
        assertEquals(expectedException.getMessage(), result.getMessage());
    }

    @Test
    void findUserExistingById() {
        // Arrange
        StudentDTO userExpected = studentDTOTest3DeUserJuan;
        // Act
        StudentDTO result = studentDAO.findById(1L);
        // Assert
        assertEquals(userExpected.getId(), result.getId()); // Me está comparando el espacio en memoria :(
    }

    @Test
    void loadDataAndSaveData(){
        // Arrange
        StudentDTO studentAddRepo = new StudentDTO(0L, "Martin", "", 6.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
        Set<StudentDTO> studentsSpectedAfterAddNewUser = new HashSet<>(); // Set que voy a esperar luego de hacer save() del estudiante studentAddRepo.
        studentsSpectedAfterAddNewUser.addAll(Set.of(
                new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0))),
                new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0))),
                studentAddRepo));
        // Act
        // Aquí verifico el saveData().
        studentDAO.save(studentAddRepo);

        // Creo uno nuevo para que se carguen los datos de 0 del JSON editado luego del save().
        // Aquí verifico el loadData().
        StudentDAO newStudentDAO = new StudentDAO(); // Creo uno nuevo para que se carguen los datos de 0 del JSON editado luego del save().
        // Assert
        assertEquals(newStudentDAO.getStudents().size(),studentsSpectedAfterAddNewUser.size());
        assertEquals(studentAddRepo,newStudentDAO.findById(studentAddRepo.getId()));
        studentDAO.delete(studentAddRepo.getId()); // Lo elimino para que no me modifique mi JSON.
    }

}