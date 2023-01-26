package com.example.vehiculosysiniestros.repository;

import com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelAndTotalLossResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelResponseDto;
import com.example.vehiculosysiniestros.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    /*
     Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    */
    List<Vehicle> findAllByOrderByManufacturingYearDesc();

    /*
     Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    */
    List<Vehicle> findAllByNumberOfWheelsGreaterThanAndManufacturingYearIs(int numberOfWheels, int manufacturingYear);

    /*
     Listar la matrícula, marca y modelo de todos los vehículos
     que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    */
    @Query("SELECT DISTINCT new com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelResponseDto(a.reportedVehicle.licensePlate, a.reportedVehicle.brand, a.reportedVehicle.model )  " +
            "FROM Accident a JOIN a.reportedVehicle r WHERE a.economicLoss > 10000")
    List<VehiclePlateBrandModelResponseDto> findVehiclesThatHadExpensiveAccidents();

    /*
     Listar la matrícula, marca y modelo de todos los vehículos que hayan
     tenido un siniestro con pérdida mayor
     de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos
    */
    @Query("SELECT new com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelAndTotalLossResponseDto(a.reportedVehicle.licensePlate, a.reportedVehicle.brand, a.reportedVehicle.model, SUM(a.economicLoss)) " +
            "FROM Accident a JOIN a.reportedVehicle r WHERE a.economicLoss > 10000 GROUP BY r.id")
    List<VehiclePlateBrandModelAndTotalLossResponseDto> findVehiclesThatHadExpensiveAccidentsAndGetTotalOfThatLoss();
}