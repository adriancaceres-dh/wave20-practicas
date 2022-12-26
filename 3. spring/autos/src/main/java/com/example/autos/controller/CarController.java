package com.example.autos.controller;

import com.example.autos.dto.request.CarRequestDto;
import com.example.autos.model.Car;
import com.example.autos.service.CarServiceImpl;
import com.example.autos.service.CarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarController {

    private final CarServiceInterface carService;

    @Autowired
    public CarController(CarServiceInterface carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Long> addCar(@RequestBody CarRequestDto carRequestDto) {
        return ResponseEntity.ok().body(carService.addCar(carRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok().body(carService.getAllCars());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Car>> getCarsByDate(
            @RequestParam String since,
            @RequestParam String to
    ) {
        return ResponseEntity.ok()
                .body(carService.getCarsFilteredByDate(LocalDate.parse(since), LocalDate.parse(to)));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Car>> getCarsByDate(
            @RequestParam double since,
            @RequestParam double to
    ) {
        return ResponseEntity.ok().body(carService.getCarsFilteredByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        return ResponseEntity.ok().body(carService.getCarById(id));
    }

}
