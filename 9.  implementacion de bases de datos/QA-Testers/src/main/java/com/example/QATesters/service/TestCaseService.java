package com.example.QATesters.service;

import com.example.QATesters.entity.TestCase;
import com.example.QATesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{
    @Autowired
    ITestCaseRepository iTestCaseRepository;
    @Override
    public void saveTestCase(TestCase testCase) {
        iTestCaseRepository.save(testCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        iTestCaseRepository.deleteById(id);
    }

    @Override
    public TestCase findTestCase(Long id) {
        return iTestCaseRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<TestCase> getAllTestCases() {
        return iTestCaseRepository.findAll();
    }

    @Override
    public List<TestCase> findByDate(LocalDate start) {
        return iTestCaseRepository.findTestCaseByLastUpdateGreaterThan(start);
    }

    @Override
    public List<TestCase> findByDate(Date start) {
        return null;
    }


}
