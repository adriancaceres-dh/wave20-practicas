package com.bootcamp.qa_testers.qa_testers.controller;

import com.bootcamp.qa_testers.qa_testers.dto.MessageDTO;
import com.bootcamp.qa_testers.qa_testers.dto.TestCaseDTO;
import com.bootcamp.qa_testers.qa_testers.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.create(testCaseDTO), HttpStatus.OK);
    }
}
