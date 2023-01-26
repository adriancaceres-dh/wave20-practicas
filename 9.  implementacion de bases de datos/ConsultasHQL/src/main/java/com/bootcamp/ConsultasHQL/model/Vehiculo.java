package com.bootcamp.ConsultasHQL.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Long anoDeFabricacion;
    private Integer cantidadDeRuedas;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehiculo")
    private List<Siniestro> siniestros;
}
