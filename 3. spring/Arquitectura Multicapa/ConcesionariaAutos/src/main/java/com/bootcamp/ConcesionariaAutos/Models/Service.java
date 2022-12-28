package com.bootcamp.ConcesionariaAutos.Models;

import lombok.Data;

import java.util.Date;

@Data
public class Service {
    private Date date;
    private Integer kilometers;
    private String description;

    public Service(Date date, Integer kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }

    public Service() {
    }
}
