package com.bootcamp.QaTesters.service;

import com.bootcamp.QaTesters.dto.request.TestCaseRequestDto;
import com.bootcamp.QaTesters.dto.response.TestCaseResponseDto;
import com.bootcamp.QaTesters.model.TestCase;
import com.bootcamp.QaTesters.repository.ITestCaseRepository;
import net.bytebuddy.asm.Advice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{
    @Autowired
    private ITestCaseRepository testCaseRepository;
    private ModelMapper mapper;

    public TestCaseService(){
        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public TestCase addNewTestCase(TestCaseRequestDto testCase) {
        TestCase newTestCase = this.mapper.map(testCase,TestCase.class);
        newTestCase = this.testCaseRepository.save(newTestCase);
        return newTestCase;
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseDto getTestCase(Long id) {
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);
        return this.mapper.map(testCase,TestCaseResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDto> getAllTestCases(String lastUpdate) {
        List <TestCaseResponseDto> testCases = new ArrayList<>();
        testCases.addAll(this.testCaseRepository.findAll()
                 		.stream().map(objeto -> mapper.map(objeto, TestCaseResponseDto.class))
                 		.collect(Collectors.toList()));
        if (lastUpdate != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate lastUpdateDate = LocalDate.parse(lastUpdate,formatter);
            testCases = testCases.stream()
                    .filter(testcase -> testcase.getLastUpdate().isAfter(lastUpdateDate))
                    .collect(Collectors.toList());
        }
        return testCases;
    }

    @Override
    @Transactional
    public TestCaseResponseDto updateTestCase(TestCaseRequestDto testCase, Long id) {
        TestCase updateTestCase = this.testCaseRepository.findById(id).orElse(null);
        updateTestCase.setTested(testCase.isTested());
        updateTestCase.setLastUpdate(LocalDate.now());
        updateTestCase.setDescription(testCase.getDescription());
        updateTestCase.setNumberOfTries(testCase.getNumberOfTries());
        updateTestCase.setPassed(testCase.isPassed());

        updateTestCase = this.testCaseRepository.save(updateTestCase);

        TestCaseResponseDto updTestCase = this.mapper.map(updateTestCase,TestCaseResponseDto.class);

        return updTestCase;

    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        this.testCaseRepository.deleteById(id);
    }
}
