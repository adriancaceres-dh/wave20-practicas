package com.bootcamp.qaTesters.controller;

import com.bootcamp.qaTesters.dto.MessageDto;
import com.bootcamp.qaTesters.dto.TestCaseDto;
import com.bootcamp.qaTesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService serviceTest;

    @PostMapping("/new")
    public ResponseEntity<MessageDto> saveTest(@RequestBody TestCaseDto testDtoReq){
        return ResponseEntity.ok(serviceTest.createEntity(testDtoReq));
    }

    @PutMapping("/id")
    public ResponseEntity<MessageDto> updateTest(@RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.ok(serviceTest.updateEntity(testCaseDto));
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDto>> getAllTests(@RequestParam(required = false) String last_update){
        if(last_update == null)
            return ResponseEntity.ok(serviceTest.getAllEntities());
        else
            return ResponseEntity.ok(serviceTest.findByUpdateDate(LocalDate.parse(last_update)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> geTestById(@PathVariable Long id){
        return ResponseEntity.ok(serviceTest.getEntityById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteTest(@PathVariable Long id){
         return ResponseEntity.ok(serviceTest.deleteEntity(id));
    }

}
