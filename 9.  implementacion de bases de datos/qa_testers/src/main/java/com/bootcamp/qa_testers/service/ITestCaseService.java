package com.bootcamp.qa_testers.service;

import com.bootcamp.qa_testers.dto.common.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService extends ICrudService<TestCaseDTO> {

    List<TestCaseDTO> getAllByLastUpdateAfter(LocalDate date);
}
