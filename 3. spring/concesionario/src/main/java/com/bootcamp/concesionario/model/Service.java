package com.bootcamp.concesionario.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;
public class Service {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String kilometers;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
