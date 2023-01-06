package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.StudentInDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentInDTO rq);
}
