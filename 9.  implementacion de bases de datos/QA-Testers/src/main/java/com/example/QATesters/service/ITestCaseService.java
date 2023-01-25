package com.example.QATesters.service;

import com.example.QATesters.entity.TestCase;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITestCaseService {
    public void saveTestCase(TestCase testCase);
    public void deleteTestCase(Long id);
    public TestCase findTestCase(Long id);
    public List<TestCase> getAllTestCases();
    List<TestCase> findByDate(LocalDate start);

    List<TestCase> findByDate(Date start);
}
