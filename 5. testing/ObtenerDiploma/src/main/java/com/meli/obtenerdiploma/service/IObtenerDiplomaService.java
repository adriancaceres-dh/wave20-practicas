package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import javax.validation.Valid;

public interface IObtenerDiplomaService {

    @Valid
    StudentDTO analyzeScores(StudentDTO rq);
}
