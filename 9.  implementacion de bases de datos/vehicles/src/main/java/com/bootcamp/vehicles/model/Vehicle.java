package com.bootcamp.vehicles.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patent;
    private String brand;
    private String model;
    @Column(name = "production_year")
    private Integer productionYear;
    @Column(name = "wheel_count")
    private Integer wheelCount;
    @OneToMany(mappedBy = "vehicle")
    List<Accident> accidents;
}
