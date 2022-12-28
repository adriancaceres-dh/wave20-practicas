package com.bootcamp.ConcesionariaAutos.Models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Auto {
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private Short doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Short countOfOwner;

    public Auto(String brand, String model, Date manufacturingDate, Integer numberOfKilometers, Short doors, Integer price, String currency, List<Service> services, Short countOfOwner) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwner = countOfOwner;
    }

    public Auto() {
    }

    public boolean agregarServicio(Service nuevoServicio){
        // Debería haber una mejor condición de verificación aquí para controlar que Service es correcto para agregar.
        if(nuevoServicio != null){
            services.add(nuevoServicio);
            return true;
        }
        return false;
    }
}
