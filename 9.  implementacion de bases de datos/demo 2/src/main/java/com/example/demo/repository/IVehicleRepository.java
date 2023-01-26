package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("update Vehicle  v set v.eliminado = true where v.id = :id")
    void logicDelete(@Param("id") Integer id);
}
