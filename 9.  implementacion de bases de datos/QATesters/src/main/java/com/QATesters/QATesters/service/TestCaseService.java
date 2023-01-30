package com.QATesters.QATesters.service;

import com.QATesters.QATesters.model.TestCase;
import com.QATesters.QATesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TestCaseService implements ITestCaseService{
    @Autowired
    ITestCaseRepository testCaseRepository;
    @Override
    public String saveTestCase(TestCase testCase) {
        testCaseRepository.save(testCase);
        return "TestCase creado";
    }

    @Override
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTestCase(TestCase newTestCase, Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);

        testCase.setDescription(newTestCase.getDescription());
        testCase.setTested(newTestCase.getTested());
        testCase.setPassed(newTestCase.getPassed());
        testCase.setLast_update(newTestCase.getLast_update());
        testCase.setNumber_of_tries(newTestCase.getNumber_of_tries());

        testCaseRepository.save(testCase);

    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);

    }

    @Override
    public List<TestCase> getTestCasesBeforeDate(LocalDate date) {
        return testCaseRepository.findAll().stream().filter(e -> e.getLast_update().isBefore(date)).collect(Collectors.toList());
    }
}
