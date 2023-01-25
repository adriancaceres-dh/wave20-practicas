package com.bootcamp.qaTesters.repository;

import com.bootcamp.qaTesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findTestCaseByLastUpdateGreaterThan(LocalDate date);
    //findTestCaseByLastUpdateGreaterThanAndPassedIsTrue
}
