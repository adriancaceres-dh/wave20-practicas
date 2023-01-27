package com.bootcamp.joyeria.repository;

import com.bootcamp.joyeria.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJewelRepository extends JpaRepository<Jewel,Integer> {
}
