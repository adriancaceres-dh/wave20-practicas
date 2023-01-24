package com.example.qa_tester.service;

import com.example.qa_tester.dto.request.TestCaseDTORequest;
import com.example.qa_tester.dto.response.TestCaseDTOResponse;
import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCaseDTOResponse addTestCase(TestCaseDTORequest testCaseDTO);
    List<TestCaseDTOResponse> getTestCases(LocalDate last_update);
    TestCaseDTOResponse getTestCaseById(Long id);
    TestCaseDTOResponse updateTestCase(TestCaseDTORequest testCaseDTO, Long id);
    String deleteTestCase(Long id);
}
