package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IJoyaRepository extends JpaRepository<Joya, Integer> {
}
