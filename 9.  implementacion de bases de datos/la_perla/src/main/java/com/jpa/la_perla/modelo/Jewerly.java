package com.jpa.la_perla.modelo;


import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "joya")
@SQLDelete(sql = "UPDATE joya SET venta_o_no=false WHERE id = ?")
@Where(clause = "venta_o_no = true")
public class Jewerly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    //eliminacion logica
    private Boolean venta_o_no;



}
