package com.bootcamp.clothes.repository;

import com.bootcamp.clothes.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findAllByDate(LocalDate date);

}
