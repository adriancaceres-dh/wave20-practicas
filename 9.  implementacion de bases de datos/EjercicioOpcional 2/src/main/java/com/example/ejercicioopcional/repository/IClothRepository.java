package com.example.ejercicioopcional.repository;

import com.example.ejercicioopcional.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothRepository extends JpaRepository<Cloth, Integer> {

    // TODO: CLAUSALAS - EQUALS - CONTAINS - LIKE - BETWEEN - GREATERTHAN

    // TODO: findBy + atributo + NOT? + clausula + AND/OR + atributo + clausula

    List<Cloth> findBySizeEquals(Integer size);

    List<Cloth> findByNameContains(String name);

}
