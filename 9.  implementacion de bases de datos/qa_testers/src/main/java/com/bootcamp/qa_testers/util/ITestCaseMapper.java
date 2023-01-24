package com.bootcamp.qa_testers.util;

import com.bootcamp.qa_testers.dto.TestCaseDTO;
import com.bootcamp.qa_testers.model.TestCase;

public interface ITestCaseMapper {
    TestCaseDTO toDTO(TestCase testCase);
    TestCase fromDTO(TestCaseDTO testCaseDTO);
}
