package com.jpa3.clothes.Repository;

import com.jpa3.clothes.Entity.PieceOfClothing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPOCRepository extends JpaRepository<PieceOfClothing, Integer> {
    List<PieceOfClothing> findBySizeEquals(String size);
    List<PieceOfClothing> findByNameContains(String name);
}
