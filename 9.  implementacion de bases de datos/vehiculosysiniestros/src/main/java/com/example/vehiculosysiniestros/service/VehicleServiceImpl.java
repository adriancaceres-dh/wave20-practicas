package com.example.vehiculosysiniestros.service;

import com.example.vehiculosysiniestros.dto.response.VehicleLicenseAndBrandResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehicleLicensePlateResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelResponseDto;
import com.example.vehiculosysiniestros.repository.VehicleRepository;
import com.example.vehiculosysiniestros.service.interfaces.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VehicleLicensePlateResponseDto> getAllLicensePlates() {
        return vehicleRepository.findAll()
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicensePlateResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleLicenseAndBrandResponseDto> getAllLicenseAndBrandOrderedByFabricationYear() {
        return vehicleRepository.findAllByOrderByManufacturingYearDesc()
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicenseAndBrandResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleLicensePlateResponseDto> getAllLicensePlatesOfVehiclesWithMoreThan4WheelsAndFabricatedThisYear() {
        return vehicleRepository.findAllByNumberOfWheelsGreaterThanAndManufacturingYearIs(4, LocalDate.now().getYear())
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicensePlateResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiclePlateBrandModelResponseDto> asd() {
        return vehicleRepository.findaaa();
    }
}
