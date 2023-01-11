package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

//Separar en clases de test segun lo que quiero testear tambien dividir lo que es Mock de lo que no

public class ObtenerDiplomaTest {

    private StudentService studentService;

    private StudentDAO studentDAO;

    private ObtenerDiplomaService obtenerDiplomaService;



    public ObtenerDiplomaTest (){
        this.studentService = new StudentService();
        this.studentDAO = new StudentDAO();
        this.obtenerDiplomaService = new ObtenerDiplomaService();
    }


    //Para testear el find lo que hay que hacer es buscar un alumno que ya exista y no crear otro porque si no ahi estoy testeando el creat
    /**
     * Se verifica que se pueda agregar un estudiante
     */
    @Test
    void addStudentDtoTest(){

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",7.0));
        subjects.add(new SubjectDTO("Idioma español",5.0));
        StudentDTO studentDto = new StudentDTO(3L,"Tammara","Tiene que esforzarse un poco mas",3.0,subjects);

        studentService.create(studentDto);

        StudentDTO studentFind = studentDAO.findById(3L);

        Assertions.assertEquals(studentDto.getId(),studentFind.getId()); //No me deja comparar objetos
        Assertions.assertEquals(studentDto.getStudentName(),studentFind.getStudentName());
        Assertions.assertEquals(studentDto.getMessage(),studentFind.getMessage());
        Assertions.assertEquals(studentDto.getAverageScore(),studentFind.getAverageScore());

    }

    /**
     * Verifica la actualizacion de los datos del estudiante
     */

    @Test
    void updateStudentTest(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",7.0));
        subjects.add(new SubjectDTO("Idioma español",5.0));
        StudentDTO studentDto = new StudentDTO(4L,"Tammara","Tiene que esforzarse un poco mas",3.0,subjects);

        studentService.create(studentDto);

        StudentDTO studentFind = studentDAO.findById(3L);

        studentFind.setStudentName("Sofia");

        studentService.update(studentFind);

        Assertions.assertEquals("Sofia",studentFind.getStudentName());
        Assertions.assertEquals(3L,studentFind.getId());

    }

    /**
     * Verifica que el estudiante sea eliminado
     */
    @Test
    void deleteStudentTest(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",7.0));
        subjects.add(new SubjectDTO("Idioma español",5.0));
        StudentDTO studentDto = new StudentDTO(5L,"Tammara","Tiene que esforzarse un poco mas",3.0,subjects);

        studentService.create(studentDto);

        studentService.delete(3L);

        boolean exist = studentDAO.exists(studentDto);

        Assertions.assertFalse(exist);
    }

    /**
     * Verifica que la cantidad devuelta de cantidad de estudiantes sean todos.
     */
    @Test
    void listAllStudentsTest(){
        Set<StudentDTO> students = studentService.getAll();
        Assertions.assertEquals(2,students.size());
    }
    /**
     * Verifica el calculo del promedio y el mensaje
     */


    @Test
    void findExistId(){
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(4L));
    } //Esto no funciona con el mock tendria que hacer una clase a aparte


}
