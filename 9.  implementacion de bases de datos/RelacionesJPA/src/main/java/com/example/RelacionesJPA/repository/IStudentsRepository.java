package com.example.RelacionesJPA.repository;

import com.example.RelacionesJPA.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentsRepository extends JpaRepository<Students,Integer> {
}
