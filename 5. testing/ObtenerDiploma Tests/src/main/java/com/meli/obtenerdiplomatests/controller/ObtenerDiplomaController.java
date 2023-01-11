package com.meli.obtenerdiplomatests.controller;

import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}
