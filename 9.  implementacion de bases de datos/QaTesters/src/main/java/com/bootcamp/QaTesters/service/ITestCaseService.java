package com.bootcamp.QaTesters.service;

import com.bootcamp.QaTesters.dto.request.TestCaseRequestDto;
import com.bootcamp.QaTesters.dto.response.TestCaseResponseDto;
import com.bootcamp.QaTesters.model.TestCase;
import java.util.List;

public interface ITestCaseService {
    public TestCase addNewTestCase(TestCaseRequestDto testCase);
    public TestCaseResponseDto getTestCase(Long id);
    public List<TestCaseResponseDto> getAllTestCases(String lastUpdate);
    public TestCaseResponseDto updateTestCase(TestCaseRequestDto testCase, Long id);
    public void deleteTestCase(Long id);

}
