package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.CarDTO;
import com.bootcamp.concesionaria.model.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehiclesService implements IVehiclesService{

    private final ModelMapper modelMapper = new ModelMapper();
    private Map<Integer, Car> cars = new HashMap<>();
    private int id = 0;

    @Override
    public CarDTO addCar(Car car) {
        return modelMapper.map(cars.put(++id, car), CarDTO.class);
    }

    @Override
    public List<CarDTO> getCars() {
        return cars.values().stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsBetweenDates(Date since, Date to) {
        return cars.values().stream()
                .filter(car -> car.getManufacturingDate().after(since) && car.getManufacturingDate().before(to))
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsBetweenPrices(Double since, Double to) {
        return cars.values().stream()
                .filter(car -> car.getPrice() > since  && car.getPrice() < to)
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCar(int id) {
        return modelMapper.map(cars.get(id), CarDTO.class);
    }
}
