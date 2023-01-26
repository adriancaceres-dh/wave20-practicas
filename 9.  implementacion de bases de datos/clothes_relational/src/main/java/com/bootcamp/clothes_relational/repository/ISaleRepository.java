package com.bootcamp.clothes_relational.repository;

import com.bootcamp.clothes_relational.model.Garment;
import com.bootcamp.clothes_relational.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByDateEquals(LocalDate date);

    @Query("SELECT s.clothes FROM sales AS s WHERE s.number = :number")
    List<Garment> findClothesBySaleNumber(@Param("number") Long number);
}
