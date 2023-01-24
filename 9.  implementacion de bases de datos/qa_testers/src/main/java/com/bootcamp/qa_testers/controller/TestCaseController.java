package com.bootcamp.qa_testers.controller;

import com.bootcamp.qa_testers.dto.ResultDTO;
import com.bootcamp.qa_testers.dto.TestCaseDTO;
import com.bootcamp.qa_testers.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResultDTO create(@RequestBody TestCaseDTO testCaseDTO) {
        return testCaseService.create(testCaseDTO);
    }

    @GetMapping("/{id}")
    public TestCaseDTO find(@PathVariable Long id) {
        return testCaseService.findById(id);
    }

    @PutMapping("/{id}")
    public ResultDTO update(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        return testCaseService.update(id, testCaseDTO);
    }

    @DeleteMapping("/{id}")
    public ResultDTO delete(@PathVariable Long id) {
        return testCaseService.delete(id);
    }

    @GetMapping("/")
    public List<TestCaseDTO> list(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<LocalDate> last_update) {

        return last_update.map(lu -> testCaseService.findUpdatedAfter(lu)).orElse(testCaseService.testCases());
    }
}
