package com.bootcamp.qa_testers.service;

import com.bootcamp.qa_testers.dto.ResultDTO;
import com.bootcamp.qa_testers.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResultDTO create(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> testCases();
    TestCaseDTO findById(Long id);
    ResultDTO update(Long id, TestCaseDTO testCaseDTO);
    ResultDTO delete(Long id);
    List<TestCaseDTO> findUpdatedAfter(LocalDate date);
}
