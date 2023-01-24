package com.bootcamp.joyeria.joyeria.repository;

import com.bootcamp.joyeria.joyeria.models.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJewelRepository extends JpaRepository<Jewel,Long> {
}
