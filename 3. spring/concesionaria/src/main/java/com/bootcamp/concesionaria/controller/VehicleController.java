package com.bootcamp.concesionaria.controller;

import com.bootcamp.concesionaria.dto.CarDTO;
import com.bootcamp.concesionaria.model.Car;
import com.bootcamp.concesionaria.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class VehicleController {

    @Autowired
    VehiclesService vehiclesService;

    @PostMapping
    public CarDTO addCar(@RequestBody Car car){
        return vehiclesService.addCar(car);
    }

    @GetMapping
    public List<CarDTO> getCars(){
        return vehiclesService.getCars();
    }

    @GetMapping("dates")
    public List<CarDTO> getCarsBetweenDates(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                         @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return vehiclesService.getCarsBetweenDates(since, to);
    }

    @GetMapping("prices")
    public List<CarDTO> getCarsBetweenPrices(@RequestParam Double since, @RequestParam Double to){
        return vehiclesService.getCarsBetweenPrices(since, to);
    }

    @GetMapping("{id}")
    public CarDTO getCar(@PathVariable int id){
        return vehiclesService.getCar(id);
    }
}
