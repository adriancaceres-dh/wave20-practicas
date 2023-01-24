package com.bootcamp.qa_testers.util;

import com.bootcamp.qa_testers.dto.TestCaseDTO;
import com.bootcamp.qa_testers.model.TestCase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TestCaseModelMapper implements ITestCaseMapper{
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public TestCaseDTO toDTO(TestCase testCase) {
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public TestCase fromDTO(TestCaseDTO testCaseDTO) {
        return modelMapper.map(testCaseDTO, TestCase.class);
    }
}
