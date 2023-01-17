package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentController {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO std1;
    private SubjectDTO sbj1, sbj2;

    @BeforeEach
    public void arrange() {
        sbj1 = new SubjectDTO("Chino", 3D);
        sbj2 = new SubjectDTO("Alemán", 5D);
        std1 = new StudentDTO(1L, "Alicia", null, null, List.of(sbj1, sbj2));
    }

    
}
