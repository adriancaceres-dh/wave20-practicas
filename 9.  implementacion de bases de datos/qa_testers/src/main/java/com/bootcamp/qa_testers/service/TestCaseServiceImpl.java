package com.bootcamp.qa_testers.service;

import com.bootcamp.qa_testers.dto.common.TestCaseDTO;
import com.bootcamp.qa_testers.dto.response.MessageDTO;
import com.bootcamp.qa_testers.model.TestCase;
import com.bootcamp.qa_testers.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO create(TestCaseDTO testCaseDTO) {
        if(testCaseDTO.getIdCase() != null)
            throw new RuntimeException("Sending IDs when creating a test case is forbidden.");

        TestCase newTestCase = modelMapper.map(testCaseDTO, TestCase.class);
        newTestCase = testCaseRepository.save(newTestCase);

        return new MessageDTO(201, "Created", "The test case was created with the following ID: " + newTestCase.getIdCase() + ".");
    }

    @Override
    public List<TestCaseDTO> getAll() {
        List<TestCase> testCases = testCaseRepository.findAll();

        return testCases.stream().map(testCase -> modelMapper.map(testCase, TestCaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO getById(Long id) {
        TestCase found = testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Test case not found."));

        return modelMapper.map(found, TestCaseDTO.class);
    }

    @Override
    public MessageDTO update(Long id, TestCaseDTO testCaseDTO) {
        if(!id.equals(testCaseDTO.getIdCase()))
            throw new RuntimeException("The endpoint ID must match the payload ID.");

        if(!testCaseRepository.existsById(id))
            throw new RuntimeException("Test case not found.");

        TestCase updated = modelMapper.map(testCaseDTO, TestCase.class);
        testCaseRepository.save(updated);

        return new MessageDTO(200, "Updated", "The test case was updated.");
    }

    @Override
    public MessageDTO deleteById(Long id) {
        if(!testCaseRepository.existsById(id))
            throw new RuntimeException("Test case not found.");

        testCaseRepository.deleteById(id);

        return new MessageDTO(200, "Deleted", "The test case was deleted.");
    }

    @Override
    public List<TestCaseDTO> getAllByLastUpdateAfter(LocalDate date) {
        List<TestCase> testCases = testCaseRepository.findAllByLastUpdateAfter(date);

        return testCases.stream().map(testCase -> modelMapper.map(testCase, TestCaseDTO.class)).collect(Collectors.toList());
    }
}
