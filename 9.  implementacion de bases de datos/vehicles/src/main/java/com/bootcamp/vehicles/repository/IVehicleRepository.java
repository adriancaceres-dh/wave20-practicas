package com.bootcamp.vehicles.repository;

import com.bootcamp.vehicles.model.Vehicle;
import com.bootcamp.vehicles.model.VehicleAccident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v.patent FROM vehicles AS v")
    List<String> findAllPatents();
    @Query("SELECT v.patent, v.brand FROM vehicles AS v ORDER BY v.productionYear")
    List<List<String>> findAllPatentBrandSortedByYear();
    @Query("SELECT v.patent FROM vehicles AS v WHERE v.wheelCount > :wheelCount AND v.productionYear = :year")
    List<String> findAllPatentsByWheelCountAndYear(@Param("wheelCount") Integer wheelCount, @Param("year") Integer year);
    @Query("SELECT v.patent, v.brand, v.model FROM vehicles AS v JOIN v.accidents AS a WHERE SUM(a.economicLoss) > :economicLoss")
    List<List<String>> findAllPatentBrandModelByEconomicLoss(@Param("economicLoss") Double economicLoss);
    @Query("SELECT v, SUM(a.economicLoss) FROM vehicles AS v JOIN v.accidents AS a WHERE SUM(a.economicLoss) > :economicLoss GROUP BY v.id")
    List<VehicleAccident> findAllByEconomicLoss(@Param("economicLoss") Double economicLoss);
}
