package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    public List<Sale> getAllByDate(LocalDate date);
}
