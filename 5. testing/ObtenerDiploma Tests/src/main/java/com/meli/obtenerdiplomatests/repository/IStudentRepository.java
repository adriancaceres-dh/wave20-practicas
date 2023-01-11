package com.meli.obtenerdiplomatests.repository;

import com.meli.obtenerdiplomatests.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
