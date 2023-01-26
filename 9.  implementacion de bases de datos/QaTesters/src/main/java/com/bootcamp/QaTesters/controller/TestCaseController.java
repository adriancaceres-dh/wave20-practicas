package com.bootcamp.QaTesters.controller;

import com.bootcamp.QaTesters.dto.request.TestCaseRequestDto;
import com.bootcamp.QaTesters.dto.response.TestCaseResponseDto;
import com.bootcamp.QaTesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;
    @PostMapping("new")
    public ResponseEntity<String> newTestCase(@RequestBody TestCaseRequestDto testCase){
        this.testCaseService.addNewTestCase(testCase);
        return new ResponseEntity<>("Caso de prueba creado con éxito", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseResponseDto>> getAllTestCase(
            @RequestParam(required = false,value = "last_update") String lastUpdate){
        List<TestCaseResponseDto> testcases = this.testCaseService.getAllTestCases(lastUpdate);
        return new ResponseEntity<>(testcases,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> getTestCaseById(@PathVariable("id") Long id){
        TestCaseResponseDto testCase = this.testCaseService.getTestCase(id);
        return new ResponseEntity<>(testCase,HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<TestCaseResponseDto> updateTestCase(@PathVariable("id") Long id,
                                                              @RequestBody TestCaseRequestDto testCase){
        TestCaseResponseDto updatedTestCase = this.testCaseService.updateTestCase(testCase,id);
        return new ResponseEntity<>(updatedTestCase,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable("id") Long id){
        this.testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("Test Case eliminado con éxito",HttpStatus.OK);
    }

}
