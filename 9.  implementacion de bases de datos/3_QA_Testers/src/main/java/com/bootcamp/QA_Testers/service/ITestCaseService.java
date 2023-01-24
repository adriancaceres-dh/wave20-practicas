package com.bootcamp.QA_Testers.service;

import com.bootcamp.QA_Testers.dto.request.TestCaseRequestDTO;
import com.bootcamp.QA_Testers.dto.response.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public Long createTestCase (TestCaseRequestDTO testCaseRequestDTO);
    public List<TestCaseResponseDTO> findAll (LocalDate last_update);
    public TestCaseResponseDTO findById(Long id);
    public TestCaseResponseDTO updateById(Long id, TestCaseRequestDTO testCaseRequestDTO);
    public Boolean deleteById(Long id);

}
