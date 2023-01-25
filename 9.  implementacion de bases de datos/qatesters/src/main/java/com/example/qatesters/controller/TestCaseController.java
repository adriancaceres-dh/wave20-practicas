package com.example.qatesters.controller;

import com.example.qatesters.dtos.MessageDto;
import com.example.qatesters.dtos.TestCaseDto;
import com.example.qatesters.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController("/api/testcases")
public class TestCaseController {
  private final ITestCaseService testCaseService;

  public TestCaseController(ITestCaseService testCaseService) {
    this.testCaseService = testCaseService;
  }

  @PostMapping("/new")
  public ResponseEntity<MessageDto> create(@RequestBody TestCaseDto dto) {
    return ResponseEntity.ok(testCaseService.create(dto));
  }

  @GetMapping()
  public ResponseEntity<List<TestCaseDto>> getAll(@RequestParam(value="last_update", required = false) String lastUpdate) {
    if(lastUpdate == null)
      return ResponseEntity.ok(testCaseService.findAll());
    else
      return ResponseEntity.ok(testCaseService.findTestCaseByLastUpdateGreaterThan(LocalDate.parse(lastUpdate)));
  }

  @PutMapping("/id")
  public ResponseEntity<MessageDto> update(@RequestBody TestCaseDto dto){
    return ResponseEntity.ok(testCaseService.update(dto));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<TestCaseDto> findById(@PathVariable Long id) {
    return ResponseEntity.ok(testCaseService.findById(id));
  }

  @DeleteMapping("/id/{id}")
  public ResponseEntity<MessageDto> delete(@PathVariable Long id){
    return ResponseEntity.ok(testCaseService.delete(id));
  }
}
