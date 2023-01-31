package com.bootcamp.vehicles.service.vehicle;

import com.bootcamp.vehicles.dto.*;
import com.bootcamp.vehicles.model.Vehicle;
import com.bootcamp.vehicles.model.templates.*;
import com.bootcamp.vehicles.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        vehicle = vehicleRepository.save(vehicle);
        return new MessageDTO(201, "The vehicle was created with the following ID: " + vehicle.getId() + ".");
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PatentDTO> getAllPatents() {
        List<Patent> patents = vehicleRepository.findAllPatents();
        return patents.stream().map(patent -> modelMapper.map(patent, PatentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PatentBrandYearDTO> getAllPatentBrandSortedByYear() {
        List<PatentBrandYear> patentBrands = vehicleRepository.findAllPatentBrandSortedByYear();
        return patentBrands.stream().map(patentBrand -> modelMapper.map(patentBrand, PatentBrandYearDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PatentWheelCountYearDTO> getAllPatentsByWheelCountAndYear(Integer wheelCount, Integer year) {
        List<PatentWheelCountYear> patents = vehicleRepository.findAllPatentsByWheelCountAndYear(wheelCount, year);
        return patents.stream().map(patent -> modelMapper.map(patent, PatentWheelCountYearDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PatentBrandModelEconomicLossDTO> getAllPatentBrandModelByEconomicLoss(Double economicLoss) {
        List<PatentBrandModelEconomicLoss> patentBrands = vehicleRepository.findAllPatentBrandModelByEconomicLoss(economicLoss);
        return patentBrands.stream().map(patentBrand -> modelMapper.map(patentBrand, PatentBrandModelEconomicLossDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleAccidentDTO> getAllByEconomicLoss(Double economicLoss) {
        List<VehicleAccident> vehicleAccidents = vehicleRepository.findAllByEconomicLoss(economicLoss);
        return vehicleAccidents.stream().map(vehicleAccident -> modelMapper.map(vehicleAccident, VehicleAccidentDTO.class)).collect(Collectors.toList());
    }
}
