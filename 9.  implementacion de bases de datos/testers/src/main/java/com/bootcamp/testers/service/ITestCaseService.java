package com.bootcamp.testers.service;

import com.bootcamp.testers.dto.MessageDto;
import com.bootcamp.testers.dto.TestCaseRequestDto;
import com.bootcamp.testers.dto.TestCaseResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    MessageDto createTestCase(TestCaseRequestDto testCaseDto);
    List<TestCaseResponseDto> getAllTestCase();
    TestCaseResponseDto getTestCaseById(Long id);
    MessageDto updateTestCaseById(Long id, TestCaseRequestDto testCaseDto);

    MessageDto deleteTestCase(Long id);
    List<TestCaseResponseDto> findByDateAfter(LocalDate date);
    public List<TestCaseResponseDto> findByDateBefore(LocalDate date);

}
