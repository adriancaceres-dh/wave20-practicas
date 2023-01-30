package com.jpa3.clothes.Repository;

import com.jpa3.clothes.Entity.PieceOfClothing;
import com.jpa3.clothes.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> getAllByDate(LocalDate saledate);
}
