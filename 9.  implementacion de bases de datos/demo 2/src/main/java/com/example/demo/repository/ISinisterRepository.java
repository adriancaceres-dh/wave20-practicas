package com.example.demo.repository;

import com.example.demo.model.Sinister;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ISinisterRepository extends JpaRepository<Sinister, Integer> {

    @Modifying
    @Query("update Sinister s set s.eliminado = true where s.id = :id")
    void logicDelete(@Param("id") Integer id);

    //Prueba método nombrado
    List<Sinister> findByFecha(@Param("fecha") LocalDateTime fecha);
}
