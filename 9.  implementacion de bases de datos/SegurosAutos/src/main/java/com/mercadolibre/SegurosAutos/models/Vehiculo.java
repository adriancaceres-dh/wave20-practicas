package com.mercadolibre.SegurosAutos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String patente;
    private String marca;
    private String modelo;

    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate anioFabricacion;
    private int cantidadRuedas;

    //@OneToMany(mappedBy = "vehiculo")
    //private List<Siniestro> siniestro;


}
