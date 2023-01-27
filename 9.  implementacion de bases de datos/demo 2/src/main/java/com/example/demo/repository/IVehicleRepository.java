package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Modifying
    @Query("update Vehicle  v set v.eliminado = true where v.id = :id")
    void logicDelete(@Param("id") Integer id);

    //Prueba método nombrado
    List<Vehicle> findByMarca(@Param("marca") String marca);
}
