package com.example.segurosvehiculos.repository;

import com.example.segurosvehiculos.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestrosRepository extends JpaRepository<Siniestro, Integer> {

}
