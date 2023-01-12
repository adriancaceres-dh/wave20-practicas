package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.io.FileNotFoundException;
import java.util.Set;

public interface IStudentService {
    void create(StudentDTO stu);
    StudentDTO read(Long id);
    void update(StudentDTO stu);
    void delete(Long id);
    Set<StudentDTO> getAll() ;
}
