package com.bootcamp.las_perlas.repository;

import com.bootcamp.las_perlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJoyaRepository extends JpaRepository<Joya, Long> {
    List<Joya> findByVentaONo(boolean ventaONo);
}
