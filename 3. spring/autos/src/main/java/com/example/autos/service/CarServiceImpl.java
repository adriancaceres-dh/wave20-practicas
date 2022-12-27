package com.example.autos.service;

import com.example.autos.dto.request.CarRequestDto;
import com.example.autos.dto.request.CarRequestToCarModel;
import com.example.autos.model.Car;
import com.example.autos.repository.CarRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarServiceImpl implements CarServiceInterface{

    private final CarRepositoryInterface carRepository;
    private final CarRequestToCarModel carRequestToCarModel;

    @Autowired
    public CarServiceImpl(CarRepositoryInterface carRepository, CarRequestToCarModel carRequestToCarModel) {
        this.carRepository = carRepository;
        this.carRequestToCarModel = carRequestToCarModel;
    }

    public long addCar(CarRequestDto carRequestDto) {
        Car newCar = carRequestToCarModel.getCarFromCarRequestDto(carRequestDto);
        newCar.setId(idToAdd());
        carRepository.addCar(newCar);

        return newCar.getId();
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public List<Car> getCarsFilteredByDate(LocalDate from, LocalDate to) {
        return carRepository.filterCarsByDate(from, to);
    }

    public List<Car> getCarsFilteredByPrice(double from, double to) {
        return carRepository.filterCarsByPrice(from,to);
    }

    public Car getCarById(long id) {
        return carRepository.getCarById(id);
    }

    private long idToAdd() {
        return carRepository.getAllCars().size() + 1;
    }
}
