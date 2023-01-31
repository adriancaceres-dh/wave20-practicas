package com.bootcamp.vehicles.service;

import com.bootcamp.vehicles.dto.PatentBrandDTO;
import com.bootcamp.vehicles.dto.PatentBrandModelDTO;
import com.bootcamp.vehicles.dto.PatentDTO;
import com.bootcamp.vehicles.dto.VehicleAccidentDTO;
import com.bootcamp.vehicles.model.VehicleAccident;
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
    public List<PatentDTO> getAllPatents() {
        List<String> patents = vehicleRepository.findAllPatents();
        return patents.stream().map(PatentDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<PatentBrandDTO> getAllPatentBrandSortedByYear() {
        List<List<String>> patentBrands = vehicleRepository.findAllPatentBrandSortedByYear();
        return patentBrands.stream().map(patentBrand -> new PatentBrandDTO(patentBrand.get(0), patentBrand.get(1))).collect(Collectors.toList());
    }

    @Override
    public List<PatentDTO> getAllPatentsByWheelCountAndYear(Integer wheelCount, Integer year) {
        List<String> patents = vehicleRepository.findAllPatentsByWheelCountAndYear(wheelCount, year);
        return patents.stream().map(PatentDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<PatentBrandModelDTO> getAllPatentBrandModelByEconomicLoss(Double economicLoss) {
        List<List<String>> patentBrands = vehicleRepository.findAllPatentBrandModelByEconomicLoss(economicLoss);
        return patentBrands.stream().map(patentBrand -> new PatentBrandModelDTO(patentBrand.get(0), patentBrand.get(1), patentBrand.get(2))).collect(Collectors.toList());
    }

    @Override
    public List<VehicleAccidentDTO> getAllByEconomicLoss(Double economicLoss) {
        List<VehicleAccident> vehicleAccidents = vehicleRepository.findAllByEconomicLoss(economicLoss);
        return vehicleAccidents.stream().map(vehicleAccident -> modelMapper.map(vehicleAccident, VehicleAccidentDTO.class)).collect(Collectors.toList());
    }
}
