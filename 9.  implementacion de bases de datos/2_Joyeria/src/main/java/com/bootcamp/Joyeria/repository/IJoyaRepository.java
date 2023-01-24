package com.bootcamp.Joyeria.repository;

import com.bootcamp.Joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IJoyaRepository extends JpaRepository<Joya,Long> {
}
