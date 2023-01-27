package com.example.wabe20.repository;

import com.example.wabe20.entity.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClothingRepositroy extends JpaRepository<Clothing,Long> {
}
