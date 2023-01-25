package com.bootcamp.testers.controller;

import com.bootcamp.testers.dto.MessageDto;
import com.bootcamp.testers.dto.TestCaseRequestDto;
import com.bootcamp.testers.dto.TestCaseResponseDto;
import com.bootcamp.testers.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService iTestCaseService;

    public TestCaseController(ITestCaseService iTestCaseService) {
        this.iTestCaseService = iTestCaseService;
    }

    @PostMapping("/new")
    private MessageDto createTestCase(@RequestBody TestCaseRequestDto testCaseRequestDto){
        return iTestCaseService.createTestCase(testCaseRequestDto);
    }

    @GetMapping("")
    private List<TestCaseResponseDto> getAllTestCase(){
        return iTestCaseService.getAllTestCase();
    }
    @GetMapping("/{id}")
    private TestCaseResponseDto getTestCaseById(@PathVariable Long id ){
        return iTestCaseService.getTestCaseById(id);
    }
    @PutMapping("/{id}")
    private MessageDto updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDto testCaseRequestDto ){
        return iTestCaseService.updateTestCaseById(id, testCaseRequestDto);
    }
    @DeleteMapping("/{id}")
    private MessageDto deleteTestCase(@PathVariable Long id){
        return iTestCaseService.deleteTestCase(id);
    }

    @GetMapping("/ex")
    private List<TestCaseResponseDto>getTestCaseByIdE(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate last_update){
        return iTestCaseService.findByDateE(last_update);
    }
    @GetMapping("/e")
    private List<TestCaseResponseDto>getTestCaseById(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate last_update){
        return iTestCaseService.findByDate(last_update);
    }

}
