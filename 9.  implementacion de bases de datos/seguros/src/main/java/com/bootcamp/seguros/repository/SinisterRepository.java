package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinisterRepository extends JpaRepository<Sinister,Long> {
}
