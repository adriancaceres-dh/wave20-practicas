package com.bootcamp.siniestrovehiculo.repository;

import com.bootcamp.siniestrovehiculo.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
