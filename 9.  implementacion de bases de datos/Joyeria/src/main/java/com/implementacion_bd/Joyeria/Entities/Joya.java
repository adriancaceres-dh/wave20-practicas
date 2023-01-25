package com.implementacion_bd.Joyeria.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "joya")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer nro_identificatorio;
    @Column(length = 20)
    public String nombre;
    @Column(length = 20)
    public String material;
    @Column(scale = 2)
    public Double peso;
    @Column(length = 20)
    public String particularidad;
    public Boolean posee_piedra;
    public Boolean ventaONo;

}
