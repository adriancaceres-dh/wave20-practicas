package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ObtenerDiplomaTest {

    @Test
    void AddStudentTest(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",7.0));
        subjects.add(new SubjectDTO("Idioma español",5.0));
        StudentDTO student = new StudentDTO("Tammara","Mensaje",7.0,subjects);

        ObtenerDiplomaService diplomaService = new ObtenerDiplomaService();

        StudentDTO studentExpect = diplomaService.analyzeScores(student);

        assertEquals(studentExpect,student);

    }
    @Test
    void findStudentByIdTest(){

    }

}
