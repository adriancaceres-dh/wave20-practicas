package com.meli.obtenerdiploma.helper;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTOHelper {
    private StudentDTOHelper() {}

    public static StudentDTO dummyStudent() {
        return new StudentDTO(null,
                "Anibal",
                null,
                null,
                List.of(new SubjectDTO("Quimica", 8D), new SubjectDTO("Algebra", 3D)));

    }
}
