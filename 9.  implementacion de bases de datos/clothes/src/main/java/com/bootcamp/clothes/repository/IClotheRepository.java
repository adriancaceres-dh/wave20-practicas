package com.bootcamp.clothes.repository;

import com.bootcamp.clothes.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IClotheRepository extends JpaRepository<Clothe, Integer> {
    List<Clothe> findAllBySize(Integer size);

    List<Clothe> findAllByNameContains(String name);
}
