package com.QATesters.QATesters.service;

import com.QATesters.QATesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;
public interface ITestCaseService {
    public String saveTestCase(TestCase testCase);
    public List<TestCase> getTestCases();
    public TestCase getTestCaseById(Long id);
    public void updateTestCase(TestCase newTestCase, Long id);
    public void deleteTestCase(Long id);
    public List<TestCase> getTestCasesBeforeDate(LocalDate date);
}
