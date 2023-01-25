package com.example.QATesters.repository;

import com.example.QATesters.entity.TestCase;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findTestCaseByLastUpdateGreaterThan(LocalDate date);
}
