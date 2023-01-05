package com.bootcamp.concesionario.services;
import com.bootcamp.concesionario.model.Car;
import com.bootcamp.concesionario.model.CarDTO;
import java.util.Date;
import java.util.List;

public interface ICarService {

    boolean addCar(Car car);

    List<CarDTO> getCars();

    List<Car> getCarBetweenDates(Date since, Date to);

    List<Car> getCarsBetweenPrices(Double since, Double to);

    Car getCar(Long id);


}
