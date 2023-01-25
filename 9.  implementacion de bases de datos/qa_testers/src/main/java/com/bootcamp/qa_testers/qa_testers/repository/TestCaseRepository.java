package com.bootcamp.qa_testers.qa_testers.repository;

import com.bootcamp.qa_testers.qa_testers.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
