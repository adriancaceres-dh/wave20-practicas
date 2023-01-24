package com.example.Joyeria_Las_Perlas.repositories;

import com.example.Joyeria_Las_Perlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyasRepository extends JpaRepository<Joya, Integer> {
}
