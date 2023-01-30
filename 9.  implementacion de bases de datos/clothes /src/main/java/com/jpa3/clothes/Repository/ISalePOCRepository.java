package com.jpa3.clothes.Repository;

import com.jpa3.clothes.Entity.PieceOfClothing;
import com.jpa3.clothes.Entity.Sale;
import com.jpa3.clothes.Entity.SalePOC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISalePOCRepository extends JpaRepository<SalePOC, Integer> {
}
