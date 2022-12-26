package com.example.autos.repository;

import com.example.autos.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepositoryImpl implements CarRepositoryInterface {

    private final List<Car> cars;

    public CarRepositoryImpl() {
        cars = new ArrayList<>();
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Long addCar(Car newCar) {
        cars.add(newCar);
        return newCar.getId();
    }

    @Override
    public Car getCarById(Long id) {
        return cars.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> filterCarsByDate(LocalDate fromDate, LocalDate toDate) {
        return cars.stream()
                .filter(c -> c.getManufacturingDate().isAfter(fromDate) && c.getManufacturingDate().isBefore(toDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> filterCarsByPrice(double fromPrice, double toPrice) {
        return cars.stream()
                .filter(c -> c.getPrice() >= fromPrice && c.getPrice() <= toPrice)
                .collect(Collectors.toList());
    }
}
