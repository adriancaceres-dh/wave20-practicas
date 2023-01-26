package com.example.QATesters.controller;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.entity.TestCase;
import com.example.QATesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createEntity(@RequestBody TestCaseDTO dto){
        return ResponseEntity.ok(testCaseService.createEntity(dto));
    }

    @PutMapping("/id")
    public ResponseEntity<MessageDTO> updateEntity(@RequestBody TestCaseDTO dto){
        return ResponseEntity.ok(testCaseService.updateEntity(dto));
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDTO>> getAllEntitys(@RequestParam(required = false) String last_update){
        if(last_update == null)
            return ResponseEntity.ok(testCaseService.getAllEntities());
        else
            return ResponseEntity.ok(testCaseService.findByUpdateDate(LocalDate.parse(last_update)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getEntity(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getEntityById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteEntity(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.deleteEntity(id));
    }
}
