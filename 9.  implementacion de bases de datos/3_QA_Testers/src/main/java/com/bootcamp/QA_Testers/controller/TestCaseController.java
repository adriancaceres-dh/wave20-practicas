package com.bootcamp.QA_Testers.controller;

import com.bootcamp.QA_Testers.dto.request.TestCaseRequestDTO;
import com.bootcamp.QA_Testers.dto.response.TestCaseResponseDTO;
import com.bootcamp.QA_Testers.service.ITestCaseService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity<Long> createTest (@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(iTestCaseService.createTestCase(testCaseRequestDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseResponseDTO>> findAll(@RequestParam(required = false)
                                                             @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                             LocalDate last_update){
        return new ResponseEntity<>(iTestCaseService.findAll(last_update),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> updateById(@PathVariable Long id,
                                                          @RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(iTestCaseService.updateById(id, testCaseRequestDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.deleteById(id),HttpStatus.OK);
    }

}
