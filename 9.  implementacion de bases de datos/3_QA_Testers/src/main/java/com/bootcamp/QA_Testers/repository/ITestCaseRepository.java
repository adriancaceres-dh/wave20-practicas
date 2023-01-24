package com.bootcamp.QA_Testers.repository;

import com.bootcamp.QA_Testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {
}
