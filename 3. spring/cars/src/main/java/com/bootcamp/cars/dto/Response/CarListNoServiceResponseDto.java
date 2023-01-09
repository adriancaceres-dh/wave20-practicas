package com.bootcamp.cars.dto.Response;

import com.bootcamp.cars.model.Service;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CarListNoServiceResponseDto {
    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;

    public CarListNoServiceResponseDto(String id, String brand, String model, String manufacturingDate, String numberOfKilometers,
                                       String doors, String price, String currency, String countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }
}
