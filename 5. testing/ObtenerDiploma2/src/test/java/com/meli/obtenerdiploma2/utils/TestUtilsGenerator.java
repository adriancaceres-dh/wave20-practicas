package com.meli.obtenerdiploma2.util;

import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.model.SubjectDTO;

import java.util.*;

public class TestUtilsGenerator {

    public static StudentDTO getStudentWith3Subjects() {
        SubjectDTO sub1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO sub2 = new SubjectDTO("Física", 6.0);
        SubjectDTO sub3 = new SubjectDTO("Química", 4.0);

        return new StudentDTO(12L, "Felipe", "", 0.0, Arrays.asList(sub1,sub2,sub3));
    }

    public static Set<StudentDTO> getStudentsList() {
        SubjectDTO sub1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO sub2 = new SubjectDTO("Física", 5.0);
        SubjectDTO sub3 = new SubjectDTO("Química", 6.0);
        SubjectDTO sub4 = new SubjectDTO("Matemática", 5.5);
        SubjectDTO sub5 = new SubjectDTO("Física", 8.0);
        SubjectDTO sub6 = new SubjectDTO("Química", 4.0);

        StudentDTO student1 =  new StudentDTO(12L, "Felipe", "", 0.0, Arrays.asList(sub1,sub2,sub3));

        StudentDTO student2 =  new StudentDTO(13L, "Robert", "", 0.0, Arrays.asList(sub1,sub5,sub6));

        StudentDTO student3 =  new StudentDTO(14L, "Orlando", "", 0.0, Arrays.asList(sub4,sub2,sub3));
        return new HashSet<StudentDTO>(){{
            add(student1);
            add(student2);
            add(student3);
        }};
    }
}