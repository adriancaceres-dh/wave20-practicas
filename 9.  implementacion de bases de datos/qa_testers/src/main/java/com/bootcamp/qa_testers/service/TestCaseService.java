package com.bootcamp.qa_testers.service;

import com.bootcamp.qa_testers.dto.ResultDTO;
import com.bootcamp.qa_testers.dto.TestCaseDTO;
import com.bootcamp.qa_testers.repository.ITestCaseRepository;
import com.bootcamp.qa_testers.util.ITestCaseMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{
    private ITestCaseMapper testCaseMapper;
    private ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseMapper testCaseMapper, ITestCaseRepository testCaseRepository) {
        this.testCaseMapper = testCaseMapper;
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public ResultDTO create(TestCaseDTO testCaseDTO) {
        System.out.println(testCaseDTO);
        var testCase = testCaseMapper.fromDTO(testCaseDTO);
        System.out.println(testCase);
        var dtoWithId = testCaseMapper.toDTO(testCaseRepository.save(testCase));
        return new ResultDTO("Test case created.", dtoWithId);
    }

    @Override
    public List<TestCaseDTO> testCases() {
        return testCaseRepository.findAll().stream()
                .map(testCaseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO findById(Long id) {
        var testCase = testCaseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Test case not found"));
        return testCaseMapper.toDTO(testCase);
    }

    @Override
    public ResultDTO update(Long id, TestCaseDTO testCaseDTO) {
        if(!testCaseRepository.existsById(id)){
            throw new RuntimeException("Test case does not exist.");
        }
        var testCase = testCaseMapper.fromDTO(testCaseDTO);
        testCase.setCaseId(id);
        testCaseRepository.save(testCase);
        return new ResultDTO("Test case updated.", testCaseMapper.toDTO(testCase));
    }

    @Override
    public ResultDTO delete(Long id) {
        testCaseRepository.deleteById(id);
        return new ResultDTO(String.format("Test case %d deleted.", id));
    }

    @Override
    public List<TestCaseDTO> findUpdatedAfter(LocalDate date) {
        return testCaseRepository.findByLastUpdateIsAfter(date).stream()
                .map(testCaseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
