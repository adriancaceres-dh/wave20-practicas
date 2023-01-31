package com.bootcamp.vehicles.repository;

import com.bootcamp.vehicles.model.Vehicle;
import com.bootcamp.vehicles.model.templates.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT new com.bootcamp.vehicles.model.templates.Patent(v.patent) FROM vehicles AS v")
    List<Patent> findAllPatents();
    @Query("SELECT new com.bootcamp.vehicles.model.templates.PatentBrandYear(v.patent, v.brand, v.productionYear) FROM vehicles AS v ORDER BY v.productionYear")
    List<PatentBrandYear> findAllPatentBrandSortedByYear();
    @Query("SELECT new com.bootcamp.vehicles.model.templates.PatentWheelCountYear(v.patent, v.wheelCount, v.productionYear) FROM vehicles AS v WHERE v.wheelCount > :wheelCount AND v.productionYear = :year")
    List<PatentWheelCountYear> findAllPatentsByWheelCountAndYear(@Param("wheelCount") Integer wheelCount, @Param("year") Integer year);
    @Query("SELECT new com.bootcamp.vehicles.model.templates.PatentBrandModelEconomicLoss(v.patent, v.brand, v.model, SUM(a.economicLoss)) FROM vehicles AS v JOIN v.accidents AS a GROUP BY v.id HAVING SUM(a.economicLoss) > :economicLoss")
    List<PatentBrandModelEconomicLoss> findAllPatentBrandModelByEconomicLoss(@Param("economicLoss") Double economicLoss);
    @Query("SELECT new com.bootcamp.vehicles.model.templates.VehicleAccident(v, SUM(a.economicLoss)) FROM vehicles AS v JOIN v.accidents AS a GROUP BY v.id HAVING SUM(a.economicLoss) > :economicLoss")
    List<VehicleAccident> findAllByEconomicLoss(@Param("economicLoss") Double economicLoss);
}
