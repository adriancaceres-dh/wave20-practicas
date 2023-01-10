package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTOUtil {
    private StudentDTOUtil() {}

    public static StudentDTO createStudentWithSubject() {
        SubjectDTO subjectDTO = new SubjectDTO("Mátematicas", 3d);
        return new StudentDTO(null,
                "Jorge",
                "Un mensaje",
                8.0,
                new ArrayList<>(List.of(subjectDTO)));

    }
}
