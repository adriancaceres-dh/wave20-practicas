package com.example.JPA_2601.repository;

import com.example.JPA_2601.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
}
