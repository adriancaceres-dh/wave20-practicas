package com.example.qa_tester.controller;

import com.example.qa_tester.dto.request.TestCaseDTORequest;
import com.example.qa_tester.dto.response.TestCaseDTOResponse;
import com.example.qa_tester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCaseDTOResponse> addTestCase(@RequestBody TestCaseDTORequest testCaseDTO) {
        return new ResponseEntity<>(testCaseService.addTestCase(testCaseDTO), HttpStatus.OK);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDTOResponse>> getTestCases(@RequestParam (required = false) LocalDate last_update) {
        return new ResponseEntity<>(testCaseService.getTestCases(last_update), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDTOResponse> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDTOResponse> updateTestCase(@RequestBody TestCaseDTORequest testCaseDTO, @PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.updateTestCase(testCaseDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }
}
