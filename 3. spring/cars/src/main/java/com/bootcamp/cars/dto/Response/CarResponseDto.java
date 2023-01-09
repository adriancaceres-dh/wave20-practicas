package com.bootcamp.cars.dto.Response;

import com.bootcamp.cars.model.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponseDto {
    private String id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public CarResponseDto(String id, String brand, String model, LocalDate manufacturingDate, String numberOfKilometers,
                          String doors, String price, String currency, List<Service> services, String countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
