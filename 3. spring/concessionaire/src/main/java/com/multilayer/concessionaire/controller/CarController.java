package com.multilayer.concessionaire.controller;

import com.multilayer.concessionaire.model.CarModel;
import com.multilayer.concessionaire.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<String> getAllCars(){
        return new ResponseEntity<>(carService.readAll().toString(), HttpStatus.OK);
    }

    @GetMapping("dates")
    public ResponseEntity<String> getAllCarsByYear(@RequestParam Integer since, @RequestParam Integer to){
        return new ResponseEntity<>(carService.readAllFilterByDate(since, to).toString(), HttpStatus.OK);
    }

    @GetMapping("prices")
    public ResponseEntity<String> getAllCarsByPrice(@RequestParam Integer since, @RequestParam Integer to){
        return new ResponseEntity<>(carService.readAllFilterByPrice(since, to).toString(), HttpStatus.OK);
    }

}
