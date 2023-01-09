package com.bootcamp.cars.dto.Request;

import com.bootcamp.cars.model.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRequestDto {
    private String id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    @JsonProperty("price")
    private double price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    //Service attributes
    private String idService;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private String kilometers;
    private String descriptions;

    public CarRequestDto(String id, String brand, String model, LocalDate manufacturingDate, String numberOfKilometers,
                         String doors, double price, String currency, List<Service> services, String countOfOwners,
                         Service service) {
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
        this.idService = service.getIdService();
        this.date = service.getDate();
        this.kilometers = service.getKilometers();
        this.descriptions = service.getDescriptions();
    }
}
