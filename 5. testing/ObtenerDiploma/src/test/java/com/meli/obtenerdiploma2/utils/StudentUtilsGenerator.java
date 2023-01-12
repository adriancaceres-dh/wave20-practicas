package com.meli.obtenerdiploma2.utils;

import com.meli.obtenerdiploma2.model.StudentDTO;
import com.meli.obtenerdiploma2.model.SubjectDTO;

import java.util.Arrays;

public class StudentUtilsGenerator {

    public static StudentDTO getStudentManySubjects(){
        SubjectDTO sub1 = new SubjectDTO("Física", 8.0);
        SubjectDTO sub2 = new SubjectDTO("Matemáticas", 6.0);
        SubjectDTO sub3 = new SubjectDTO("Español", 5.0);

        return new StudentDTO(1L, "Pedro", null, null, Arrays.asList(sub1,sub2,sub3));
    }


    public static StudentDTO getStudentManySubjectsOver9(){
        SubjectDTO sub1 = new SubjectDTO("Física", 10.0);
        SubjectDTO sub2 = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO sub3 = new SubjectDTO("Español", 10.0);

        return new StudentDTO(1L, "Pedro", null, null, Arrays.asList(sub1,sub2,sub3));
    }

    public static StudentDTO getStudentResultsManySubjects(){
        SubjectDTO sub1 = new SubjectDTO("Física", 8.0);
        SubjectDTO sub2 = new SubjectDTO("Matemáticas", 6.0);
        SubjectDTO sub3 = new SubjectDTO("Español", 5.0);

        return new StudentDTO(1L, "Pedro",  "El alumno Pedro ha obtenido un promedio de 6.33. Puedes mejorar.", 19.0/3, Arrays.asList(sub1,sub2,sub3));
    }


    public static StudentDTO getStudentOneSubject(){
        SubjectDTO sub1 = new SubjectDTO("Física", 8.0);

        return new StudentDTO(1L, "Pedro", null, null, Arrays.asList(sub1));
    }

    public static StudentDTO getStudentResultsOneSubject(){
        SubjectDTO sub1 = new SubjectDTO("Física", 8.0);

        return new StudentDTO(1L, "Pedro",  "El alumno Pedro ha obtenido un promedio de 8.0. Puedes mejorar.", 8.0, Arrays.asList(sub1));
    }
}
