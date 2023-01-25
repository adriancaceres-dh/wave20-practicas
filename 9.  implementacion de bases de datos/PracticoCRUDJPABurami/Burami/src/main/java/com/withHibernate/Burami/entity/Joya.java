package com.withHibernate.Burami.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJoya;
    private String nombre;
    private String material;
    private Integer peso;
    private String Particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
