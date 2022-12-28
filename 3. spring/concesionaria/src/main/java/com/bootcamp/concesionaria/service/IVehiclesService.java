package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.CarDTO;
import com.bootcamp.concesionaria.model.Car;

import java.util.Date;
import java.util.List;

public interface IVehiclesService {
    CarDTO addCar(Car car);

    List<CarDTO> getCars();

    List<CarDTO> getCarsBetweenDates(Date since, Date to);

    List<CarDTO> getCarsBetweenPrices(Double since, Double to);

    CarDTO getCar(int id);
}
