package com.bootcamp.ConsultasHQL.repository;

import com.bootcamp.ConsultasHQL.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
