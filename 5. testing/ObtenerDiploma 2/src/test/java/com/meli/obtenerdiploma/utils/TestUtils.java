package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static StudentDTO buildValidStudent () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", 6d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "Pepito", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentLowercaseName () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", 6d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(null, "laura", null, null, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjects () {
        SubjectDTO iSub1 = new SubjectDTO("Mátematicas", 11d);
        SubjectDTO iSub2 = new SubjectDTO("química", 7d);

        return new StudentDTO(null, "Jacinta", null, null, List.of(iSub1, iSub2));
    }

    public static StudentDTO buildInvalidStudentEmptySubjects () {
        return new StudentDTO(null, "Jacinta", null, null, new ArrayList<>());
    }

    public static StudentDTO buildInvalidStudentNameGreaterThan50Characters () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", 6d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "PepitomotrPepitomotrPepitomotrPepitomotrPepitomotry", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentEmptyName () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", 6d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, null, "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjectScoreGreaterThan10 () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", 11d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjectEmptyName () {
        SubjectDTO sub1 = new SubjectDTO(null, 1d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjectScoreLesserThan0 () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", -1d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjectNameGreaterThan30Characters () {
        SubjectDTO sub1 = new SubjectDTO("MátematicaMátematicaMátematicas", 8d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjectNameStartsWithLowercase () {
        SubjectDTO sub1 = new SubjectDTO("mátematicas", 8d);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

    public static StudentDTO buildInvalidStudentSubjectEmptyScore () {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", null);
        SubjectDTO sub2 = new SubjectDTO("Química", 7d);

        return new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 7.5. Puedes mejorar.", 7.5, List.of(sub1, sub2));
    }

}
