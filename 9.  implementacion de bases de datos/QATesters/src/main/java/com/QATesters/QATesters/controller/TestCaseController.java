package com.QATesters.QATesters.controller;

import com.QATesters.QATesters.model.TestCase;
import com.QATesters.QATesters.service.ITestCaseService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public String createNewTestCase(@RequestBody TestCase testCase){
//    Crear un nuevo caso de prueba.
        return testCaseService.saveTestCase(testCase);

    }

    @GetMapping("/api/testcases/{id}")
    public TestCase getTestCaseById(@PathVariable Long id){
//    Devolver un caso de prueba por id.
       return testCaseService.getTestCaseById(id);

    }

    @PutMapping("/api/testcases/{id}")
    public void updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase){
//    Actualizar un caso de prueba por id.
        testCaseService.updateTestCase(testCase, id);

    }
    @DeleteMapping("/api/testcases/{id}")
    public void deleteTestCase(@PathVariable Long id){
//    Eliminar un tutorial por id.
        testCaseService.deleteTestCase(id);

    }
    @GetMapping(value = "/api/testcases")
    public List<TestCase> getTestCases(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") @Nullable LocalDate last_update){
//    Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
        if (last_update == null){
            return testCaseService.getTestCases();
        }

        return testCaseService.getTestCasesBeforeDate(last_update);
    }

}
