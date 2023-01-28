package com.example.QATesters.repository;

import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findTestCaseByLastUpdateGreaterThan(LocalDate date);
}
