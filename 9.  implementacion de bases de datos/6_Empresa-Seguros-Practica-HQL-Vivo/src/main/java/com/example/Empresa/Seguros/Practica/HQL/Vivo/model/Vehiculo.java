package com.example.Empresa.Seguros.Practica.HQL.Vivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anhoFabricacion;
    private Integer cantRuedas;
    @OneToMany(mappedBy = "vehiculoDenunciado")
    private List<Siniestro> siniestros;

}
