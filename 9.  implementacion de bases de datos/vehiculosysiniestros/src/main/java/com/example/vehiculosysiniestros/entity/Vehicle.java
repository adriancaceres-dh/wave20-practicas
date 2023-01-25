package com.example.vehiculosysiniestros.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "license_plate")
    private String licensePlate;
    private String brand;
    private String model;
    @Column(name = "manufacturing_year")
    private Integer manufacturingYear;
    @Column(name = "number_of_wheels")
    private Integer numberOfWheels;
    @OneToMany
    private List<Accident> reportedAccidents;
}
