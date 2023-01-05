package com.bootcamp.concesionario.services;

import com.bootcamp.concesionario.model.Car;
import com.bootcamp.concesionario.model.CarDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

@Service
public class CarService implements ICarService {
    private Map<Long,Car> cars = new HashMap<>();
    private Long id;

    //Averiguar que es esto
    @PostConstruct
    private void postContruct(){
        this.id = 1L;
    }

    public boolean addCar(Car car){
        this.cars.put(id,car);
        this.id +=1;
        return true;
    }

    public List<CarDTO> getCars(){
        return cars.entrySet().stream().map(x-> getCarDTO(x.getValue())).collect(Collectors.toList());

    }

    @Override
    public List<Car> getCarBetweenDates( Date since, Date to){
        return cars.entrySet().stream().map(c -> { Car car=c.getValue();
            if (car.getManufacturingDate().after(since) && car.getManufacturingDate().before(to)) {
                return car;
            }
            return null;
        }).collect(Collectors.toList());
    }


    @Override
    public List<Car> getCarsBetweenPrices(Double since, Double to) {
        return cars.entrySet().stream().map(x -> {
            Car car = x.getValue();
            if (car.getPrice() >= since && car.getPrice() <= to) {
                return car;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public Car getCar(Long id) {
        return cars.get(id);
    }
    private CarDTO getCarDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setCurrency(car.getCurrency());
        carDTO.setDoors(car.getDoors());
        carDTO.setModel(car.getModel());
        carDTO.setCountOfOwners(car.getCountOfOwners());
        carDTO.setManufacturingDate(car.getManufacturingDate());
        carDTO.setNumberOfKilometers(car.getNumberOfKilometers());
        carDTO.setPrice(car.getPrice());
        return carDTO;
    }

}
