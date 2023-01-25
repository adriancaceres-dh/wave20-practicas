package com.example.QATesters.repository;

import com.example.QATesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findTestCaseByLastUpdateGreaterThanAndPassedIsTrue(LocalDate date);

}
