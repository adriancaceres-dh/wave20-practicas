package com.example.autos.service;

import com.example.autos.dto.request.CarRequestDto;
import com.example.autos.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarServiceInterface {
    long addCar(CarRequestDto carRequestDto);
    List<Car> getAllCars();
    List<Car> getCarsFilteredByDate(LocalDate from, LocalDate to);
    List<Car> getCarsFilteredByPrice(double from, double to);
    Car getCarById(long id);
}
