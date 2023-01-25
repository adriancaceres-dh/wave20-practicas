package com.bootcamp.ImplementandoJPA.repository;

import com.bootcamp.ImplementandoJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
