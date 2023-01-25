package com.example.CrudConJpaEjPractico.repository;
import com.example.CrudConJpaEjPractico.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJoyaRepository extends JpaRepository<Joya, Integer> {
}
