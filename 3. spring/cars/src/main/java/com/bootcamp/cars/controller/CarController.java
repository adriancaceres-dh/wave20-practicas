package com.bootcamp.cars.controller;


import com.bootcamp.cars.dto.Request.CarRequestDto;
import com.bootcamp.cars.dto.Response.CarListNoServiceResponseDto;
import com.bootcamp.cars.dto.Response.CarResponseDto;
import com.bootcamp.cars.model.Car;
import com.bootcamp.cars.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("v1/api")
public class CarController {
    @Autowired
    ICarService carService;

    //Return all elements of the list
    @GetMapping("/vehicles")
    ResponseEntity<List<CarListNoServiceResponseDto>> getCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    //Return an element of the list
    @GetMapping("/vehicles/{id}")
    ResponseEntity<CarResponseDto> getCarById(@PathVariable String id) {
        return new ResponseEntity<>(carService.findCarId(id), HttpStatus.FOUND);
    }

    @PostMapping("/vehicle")
    public ResponseEntity<String> addCars(@RequestBody CarRequestDto carRequestDto) {
        return new ResponseEntity<>(carService.addCar(carRequestDto), HttpStatus.CREATED);
    }

    //Return a list of cars by manufacturing date
    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<CarListNoServiceResponseDto>> getCarsByManufacturingDate(@RequestParam String since,
                                                                                        @RequestParam String to) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(since, df);
        LocalDate endDate = LocalDate.parse(to, df);
        return new ResponseEntity<>(carService.getCarsByManufacturingDate(startDate, endDate), HttpStatus.FOUND);
    }

    //Return a list of cars by price
    @GetMapping("vehicles/prices")
    public ResponseEntity<List<CarListNoServiceResponseDto>> getCarsByPrice(@RequestParam String since,
                                                                            @RequestParam String to) {
        return new ResponseEntity<>(carService.getCarsByPrice(Double.parseDouble(since), Double.parseDouble(to)),
                HttpStatus.FOUND);
    }
}
