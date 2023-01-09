package com.bootcamp.cars.repository;

import com.bootcamp.cars.model.Car;
import com.bootcamp.cars.model.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    private List<Car> cars;
    private List<Service> services;

    //Constructor
    public CarRepository() {
        cars = new ArrayList<>();
        services = new ArrayList<>();
    }

    //Getter - List of cars
    public List<Car> getCars() {
        return cars;
    }

    public boolean addCarsToList(Car car) {
        cars.add(car);
        services.add(car.getServices().get(0));
        return true;
    }

    public Car findIdCar(String id) {
        Car car = cars.stream().filter(c -> c.getId().equals(id)).collect(Collectors.toList()).get(0);
        return car;
    }
}
