package com.example.crud_joyeria.repository;

import com.example.crud_joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<Joya,Long> {
}
