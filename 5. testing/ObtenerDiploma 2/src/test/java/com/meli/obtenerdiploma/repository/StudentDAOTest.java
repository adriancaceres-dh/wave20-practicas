package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    //Debería probar que se lance correctamente la excepcion inherente a las validaciones?
    //O que se este controlando bien esa excepción?
    //En un entorno real, esto se realiza? teniendo en cuenta que puede haber tantas validaciones como
    //atributos del modelo.

    //Se utiliza otro metodo para corroborar que se haya guardado el estudiante porque
    //el metodo a testear devuelve void. Esto resulta un poco acoplado y es una alerta sobre
    //cómo está definido el código.
    @Test
    @DisplayName("Guarda un estudiante en base")
    void saveOK() {
        //arrange
        StudentDTO stu = getStudentDto();
        //act
        studentDAO.save(stu);
        boolean result = studentDAO.exists(stu);
        //assert
        Assertions.assertTrue(result);
        studentDAO.delete(stu.getId());
    }


    @Test
    @DisplayName("Intenta guardar un nulo")
    //Este test seguro fallaría porque el metodo save llama al
    //metodo delete enviandole como parametro student.getId() lo que debería lanzar una excepción que
    //no esta controlada, por ende, no se sabe qué esperar cuando se recibe un null.
    @NullSource
    void saveNull(StudentDTO stu ) {


    }

    @Test
    @DisplayName("Elimina un student que está en base")
    void deleteOKWhenIdExists() {
        //arrange
        StudentDTO stu = getStudentDto();
        studentDAO.save(stu);
        boolean expectedResult = true;
        //act
        boolean result = studentDAO.delete(stu.getId());
        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("No elimina un student porqque no está en base")
    void deleteOKWhenNotIdExists() {
        //arrange
        StudentDTO stu = getStudentDto();
        boolean expectedResult = false;
        //act
        boolean result = studentDAO.delete(stu.getId());
        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Existe un student guardado en base")
    void existsOKWhenExists() {
        //arrange
        StudentDTO stu = getStudentDto();
        studentDAO.save(stu);
        boolean expectedResult = true;
        //act
        boolean result = studentDAO.exists(stu);
        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("No existe un student guardado en base")
    void existsOKWhenNotExists() {
        //arrange
        StudentDTO stu = getStudentDto();
        studentDAO.delete(stu.getId());
        boolean expectedResult = false;
        //act
        boolean result = studentDAO.exists(stu);
        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Encuentra un estudiante guardado en base")
    void findByIdOK() {
        //arrange
        StudentDTO stu = getStudentDto();
        studentDAO.save(stu);
        StudentDTO expectedResult = stu;
        //act
        StudentDTO result = studentDAO.findById(stu.getId());
        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Lanza excepcion porque no encuentra un estudiante en base")
    void findByIdThrowsStudentNotFoundException() {
        StudentDTO stu = getStudentDto();
        try {
            studentDAO.findById(stu.getId());
            fail("No se lanzó la excepión esperada");
        } catch (StudentNotFoundException e) {

        }

    }


    public StudentDTO getStudentDto() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("karen");
        studentDTO.setId(1L);
        studentDTO.setMessage("Mensaje de prueba");
        studentDTO.setAverageScore(4.25);
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematica");
        subjectDTO.setScore(9D);
        subjects.add(subjectDTO);
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }
}