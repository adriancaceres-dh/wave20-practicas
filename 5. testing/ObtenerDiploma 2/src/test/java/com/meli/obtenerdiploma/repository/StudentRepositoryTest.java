package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    long id=0;

    StudentRepository studentRepository = new StudentRepository();

    //Se deben cargar los datos de un archivo
    @Test
    void findAll() {
        //arrange
        //Aca deberia hacerle un getter a la lista de estudiantes para poder verificar
        int expectedResult = 2;

        //act
        int result = studentRepository.findAll().size();

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    //Puedo hacer lo casos de excepción donde:
    //1- No se encuentra el archivo (le cambio la ruta)
    //2- El archivo no es compatible con el esperado, por ejemplo. DIFICIL



    @Test
    //Si se atrapó alguna de las excepciones que lanza el método que se esta testeando
    //entonces la lista que retorne estará vacía.
    //Debo cambiar el nombre del archivo y provocar este comportamiento? creo que si.
    void findAllThrowsAnyException() throws IOException {
        //arrange
        Set<StudentDTO> results;
        boolean result = false;
        //act
        try{
            result= !studentRepository.findAll().isEmpty();
        } catch (Exception e) {

        }
        //assert
        assertTrue(result);
    }

    public StudentDTO getStudentDto() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("karen");
        studentDTO.setId(++id);
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