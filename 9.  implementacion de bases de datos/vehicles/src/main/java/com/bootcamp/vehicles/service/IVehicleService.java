package com.bootcamp.vehicles.service;

import com.bootcamp.vehicles.dto.PatentBrandDTO;
import com.bootcamp.vehicles.dto.PatentBrandModelDTO;
import com.bootcamp.vehicles.dto.PatentDTO;
import com.bootcamp.vehicles.dto.VehicleAccidentDTO;

import java.util.List;

public interface IVehicleService {

    List<PatentDTO> getAllPatents();
    List<PatentBrandDTO> getAllPatentBrandSortedByYear();
    List<PatentDTO> getAllPatentsByWheelCountAndYear(Integer wheelCount, Integer year);
    List<PatentBrandModelDTO> getAllPatentBrandModelByEconomicLoss(Double economicLoss);
    List<VehicleAccidentDTO> getAllByEconomicLoss(Double economicLoss);
}
