package com.meli.obtenerdiplomatests.repository;

import com.meli.obtenerdiplomatests.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}