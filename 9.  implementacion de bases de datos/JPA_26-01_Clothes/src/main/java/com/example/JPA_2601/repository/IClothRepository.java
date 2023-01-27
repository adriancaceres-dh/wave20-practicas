package com.example.JPA_2601.repository;

import com.example.JPA_2601.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothRepository extends JpaRepository<Cloth, Integer> {
    List<Cloth> findByTalle(Integer talle);
    List<Cloth> findByNombreContains(String nombre);
}
