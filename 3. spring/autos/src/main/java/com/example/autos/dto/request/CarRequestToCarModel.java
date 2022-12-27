package com.example.autos.dto.request;

import com.example.autos.model.Car;
import com.example.autos.model.CarServiceModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRequestToCarModel {

    public Car getCarFromCarRequestDto(CarRequestDto carRequestDto) {
        Car newCar = new Car();
        newCar.setBrand(carRequestDto.getBrand());
        newCar.setModel(carRequestDto.getModel());
        newCar.setManufacturingDate(LocalDate.parse(carRequestDto.getManufacturingDate()));
        newCar.setNumberOfKilometers(Double.parseDouble(carRequestDto.getNumberOfKilometers()));
        newCar.setDoors(Integer.parseInt(carRequestDto.getDoors()));
        newCar.setPrice(Double.parseDouble(carRequestDto.getPrice()));
        newCar.setCurrency(carRequestDto.getCurrency());
        newCar.setServices(getServicesFromServiceRequestDto(carRequestDto.getServices()));
        newCar.setCountOfOwners(Integer.parseInt(carRequestDto.getCountOfOwners()));
        return newCar;
    }

    private List<CarServiceModel> getServicesFromServiceRequestDto(List<ServiceRequestDto> services) {
        List<CarServiceModel> newCarServiceList = new ArrayList<>();
        for(ServiceRequestDto serviceRequestDto: services) {
            CarServiceModel newCarService = new CarServiceModel();
            newCarService.setDate(LocalDate.parse(serviceRequestDto.getDate()));
            newCarService.setKilometers(Double.parseDouble(serviceRequestDto.getKilometers()));
            newCarService.setDescriptions(serviceRequestDto.getDescriptions());
            newCarServiceList.add(newCarService);
        }
        return newCarServiceList;
    }
}
