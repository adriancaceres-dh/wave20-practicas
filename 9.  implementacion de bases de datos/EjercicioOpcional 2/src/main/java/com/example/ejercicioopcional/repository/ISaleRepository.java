package com.example.ejercicioopcional.repository;

import com.example.ejercicioopcional.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
}
