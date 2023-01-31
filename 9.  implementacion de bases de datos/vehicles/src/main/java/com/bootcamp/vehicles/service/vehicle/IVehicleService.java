package com.bootcamp.vehicles.service.vehicle;

import com.bootcamp.vehicles.dto.*;

import java.util.List;

public interface IVehicleService {

    MessageDTO createVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    List<PatentDTO> getAllPatents();
    List<PatentBrandYearDTO> getAllPatentBrandSortedByYear();
    List<PatentWheelCountYearDTO> getAllPatentsByWheelCountAndYear(Integer wheelCount, Integer year);
    List<PatentBrandModelEconomicLossDTO> getAllPatentBrandModelByEconomicLoss(Double economicLoss);
    List<VehicleAccidentDTO> getAllByEconomicLoss(Double economicLoss);
}
