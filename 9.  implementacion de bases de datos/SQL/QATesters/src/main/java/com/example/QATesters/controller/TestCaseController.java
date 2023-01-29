package com.example.QATesters.controller;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createEntity(@RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok(testCaseService.createEntity(testCaseDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getEntityById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getEntityById(id));
    }
    @GetMapping()
    public ResponseEntity<List<TestCaseDTO>> getAllEntities(@RequestParam(required = false) String last_update){
        if(last_update == null)
            return ResponseEntity.ok(testCaseService.getAllEntities());
        else
            return ResponseEntity.ok(testCaseService.findByUpdateDate(LocalDate.parse(last_update)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateEntity(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok(testCaseService.updateEntity(id, testCaseDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteEntity(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.deleteEntity(id));
    }
}
