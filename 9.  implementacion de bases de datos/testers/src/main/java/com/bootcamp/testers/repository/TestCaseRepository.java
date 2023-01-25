package com.bootcamp.testers.repository;

import com.bootcamp.testers.dto.TestCaseResponseDto;
import com.bootcamp.testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("SELECT f From TestCase f where f.lastUpdate <= :date")
    List<TestCase> findDateTimeBefore(@Param("date") LocalDate date);
    List<TestCase> findByLastUpdateIsAfter(LocalDate lastUpdate);

}
