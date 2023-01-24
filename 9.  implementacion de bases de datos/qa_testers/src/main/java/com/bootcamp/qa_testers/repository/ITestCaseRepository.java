package com.bootcamp.qa_testers.repository;

import com.bootcamp.qa_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findAllByLastUpdateAfter(LocalDate date);
}
