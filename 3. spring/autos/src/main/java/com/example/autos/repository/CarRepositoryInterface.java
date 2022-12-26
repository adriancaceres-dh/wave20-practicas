package com.example.autos.repository;

import com.example.autos.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepositoryInterface {
    List<Car> getAllCars();
    Long addCar(Car newCar);
    Car getCarById(Long id);
    List<Car> filterCarsByDate(LocalDate fromDate, LocalDate toDate);
    List<Car> filterCarsByPrice(double fromPrice, double toPrice);
}
