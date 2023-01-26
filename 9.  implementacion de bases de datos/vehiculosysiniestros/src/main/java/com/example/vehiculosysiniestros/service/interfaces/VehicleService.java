package com.example.vehiculosysiniestros.service.interfaces;

import com.example.vehiculosysiniestros.dto.response.VehicleLicenseAndBrandResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehicleLicensePlateResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelAndTotalLossResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelResponseDto;

import java.util.List;

public interface VehicleService {
    List<VehicleLicensePlateResponseDto> getAllLicensePlates();
    List<VehicleLicenseAndBrandResponseDto> getAllLicenseAndBrandOrderedByFabricationYear();
    List<VehicleLicensePlateResponseDto> getAllLicensePlatesOfVehiclesWithMoreThan4WheelsAndFabricatedThisYear();
    List<VehiclePlateBrandModelResponseDto> getVehiclesThatSufferedExpensiveAccidents();
    List<VehiclePlateBrandModelAndTotalLossResponseDto> getVehiclesThatSufferedExpensiveAccidentsAndGetTotalLoss();
}
