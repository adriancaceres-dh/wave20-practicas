package com.example.demo.repository;

import com.example.demo.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISinisterRepository extends JpaRepository<Sinister, Integer> {

    @Query("update Sinister s set s.eliminado = true where s.id = :id")
    void logicDelete(@Param("id") Integer id);
}
