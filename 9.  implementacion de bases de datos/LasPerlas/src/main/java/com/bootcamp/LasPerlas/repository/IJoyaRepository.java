package com.bootcamp.LasPerlas.repository;

import com.bootcamp.LasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //no es necesario la anotación si extiende de JpaRepository
public interface IJoyaRepository extends JpaRepository<Joya, Integer> {
}
