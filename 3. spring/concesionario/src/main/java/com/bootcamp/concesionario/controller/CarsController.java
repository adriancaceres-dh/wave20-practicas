package com.bootcamp.concesionario.controller;

import com.bootcamp.concesionario.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.concesionario.model.Car;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarsController {

    @Autowired
    CarService carService;

    @PostMapping
    public boolean addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("dates")
    public List<Car> getCarBetweenDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return carService.getCarBetweenDates(since,to);
    }

    @GetMapping("prices")
    public List<Car> getCarsBetweenPrices(@RequestParam Double since, @RequestParam Double to){
        return carService.getCarsBetweenPrices(since, to);
    }

    @GetMapping("{id}")
    public Car getCarsBetweenPrices(@PathVariable Long id){
        return carService.getCar(id);
    }




}
