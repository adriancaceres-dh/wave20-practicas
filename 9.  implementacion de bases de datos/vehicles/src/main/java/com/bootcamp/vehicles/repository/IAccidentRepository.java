package com.bootcamp.vehicles.repository;

import com.bootcamp.vehicles.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccidentRepository extends JpaRepository<Accident, Long> {
}
