package com.example.qatesters.service;

import com.example.qatesters.dtos.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService extends ICrudService<TestCaseDto> {
  List<TestCaseDto> findTestCaseByLastUpdateGreaterThan(LocalDate date);
}
