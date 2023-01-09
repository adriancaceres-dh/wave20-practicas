package com.bootcamp.cars.service;

import com.bootcamp.cars.dto.Request.CarRequestDto;
import com.bootcamp.cars.dto.Response.CarListNoServiceResponseDto;
import com.bootcamp.cars.dto.Response.CarResponseDto;
import com.bootcamp.cars.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarService {

    //Method return a list
    public List<CarListNoServiceResponseDto> getCars();

    //Add car
    public String addCar(CarRequestDto carRequestDto);

    //Find car by id
    public CarResponseDto findCarId(String id);

    //List of cars filter by manufacturing date
    public List<CarListNoServiceResponseDto> getCarsByManufacturingDate(LocalDate manufacturingDateSince,
                                                                        LocalDate manufacturingDateTo);

    //List of cars filter by price
    public List<CarListNoServiceResponseDto> getCarsByPrice(double priceSince, double priceTo);
}
