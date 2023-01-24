package com.example.qa_tester.repository;

import com.example.qa_tester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
