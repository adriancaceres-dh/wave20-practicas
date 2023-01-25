package com.bootcamp.joyerialasperlas.repository;

import com.bootcamp.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoyaRepository extends JpaRepository<Joya, Integer> {

    @Query("from Joya where ventaONo = true")
     List<Joya> getAll();
}
