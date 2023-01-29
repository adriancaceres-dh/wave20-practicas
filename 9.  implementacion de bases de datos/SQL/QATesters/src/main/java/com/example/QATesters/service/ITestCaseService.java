package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService extends ICRUDService<TestCaseDTO>{
    List<TestCaseDTO> findByUpdateDate(LocalDate date);
}
