package com.bootcamp.qa_testers.controller;

import com.bootcamp.qa_testers.dto.common.TestCaseDTO;
import com.bootcamp.qa_testers.dto.response.MessageDTO;
import com.bootcamp.qa_testers.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.create(testCaseDTO));
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getTestCases(
            @RequestParam(value = "last_update", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE) LocalDate lastUpdate) {
        if(lastUpdate != null)
            return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getAllByLastUpdateAfter(lastUpdate));

        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateTestCaseById(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.update(id, testCaseDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageDTO> deleteTestCaseByUd(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(testCaseService.deleteById(id));
    }
}
