package com.meli.obtenerdiploma.util;

import com.github.javafaker.Faker;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTOUtil {
    private StudentDTOUtil() {}

    public static StudentDTO createStudentWithSubject() {
        Faker faker = new Faker();
        SubjectDTO subjectDTO = new SubjectDTO("Mátematicas", 3d);
        return new StudentDTO(null,
                faker.name().fullName(),
                null,
                null,
                new ArrayList<>(List.of(subjectDTO)));

    }
}
