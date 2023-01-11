package com.meli.obtenerdiplomatests.service;

import com.meli.obtenerdiplomatests.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
