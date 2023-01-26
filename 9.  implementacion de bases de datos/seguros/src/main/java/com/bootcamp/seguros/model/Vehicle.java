package com.bootcamp.seguros.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Vehiculo")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate anoDeFabricacion;
    private int cantidadDeRuedas;
    @OneToMany(mappedBy = "vehicle",fetch=FetchType.EAGER)
    private List<Sinister> sinisterList;

}
