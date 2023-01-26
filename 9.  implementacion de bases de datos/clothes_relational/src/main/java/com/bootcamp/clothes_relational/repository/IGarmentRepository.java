package com.bootcamp.clothes_relational.repository;

import com.bootcamp.clothes_relational.model.Garment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGarmentRepository extends JpaRepository<Garment, Long> {

    List<Garment> findBySizeEquals(String size);
    List<Garment> findByNameContaining(String term);
}
