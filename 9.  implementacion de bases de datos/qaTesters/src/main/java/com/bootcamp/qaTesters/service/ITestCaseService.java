package com.bootcamp.qaTesters.service;

import com.bootcamp.qaTesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService extends  ICrudService<TestCaseDto>{
    List<TestCaseDto> findByUpdateDate(LocalDate date);
}
