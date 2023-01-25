package com.example.vehiculosysiniestros.repository;

import com.example.vehiculosysiniestros.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
