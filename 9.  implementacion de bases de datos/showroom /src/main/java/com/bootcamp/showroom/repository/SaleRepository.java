package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
