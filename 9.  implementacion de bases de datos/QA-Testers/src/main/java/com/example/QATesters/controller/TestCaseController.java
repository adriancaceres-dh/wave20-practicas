package com.example.QATesters.controller;

import com.example.QATesters.entity.TestCase;
import com.example.QATesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController()
public class TestCaseController {
    @Autowired
    ITestCaseService iTestCaseService;
    @PostMapping("/testcases/new")
    public String createTestCase(@RequestBody TestCase testCase){
        iTestCaseService.saveTestCase(testCase);
        return "El testcase:"+ testCase.getId_case()+" fue creado";
    }
    @GetMapping("/testcases")
    public List<?> getTestCases(){
        return iTestCaseService.getAllTestCases();
    }

    @GetMapping("/testcases/{id}")
    public TestCase findTestCaseById(@PathVariable long id){
        return iTestCaseService.findTestCase(id);
    }
    @PutMapping("/testcases/{id}/{newId}")
    public TestCase updateTestCaseById(@PathVariable Long id, @PathVariable Long newId){
        TestCase testCase = iTestCaseService.findTestCase(id);
        testCase.setId_case(newId);
        testCase.setLastUpdate(LocalDate.now());
        return testCase;
    }
    @DeleteMapping("testcases/{id}")
    public String deleteTestCaseById(@PathVariable Long id){
        iTestCaseService.deleteTestCase(id);
        return "El test case"+ id + " fue eliminado";
    }
    @GetMapping("/testcases/date")
    public List<TestCase> findByDate(@RequestParam(value = "last_update", required = false) String byDate){
        return iTestCaseService.findByDate(LocalDate.parse(byDate));
    }


}
