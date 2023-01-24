package com.bootcamp.joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@SQLDelete(sql = "UPDATE joya SET venta_o_no = false WHERE nro_id=?")
@Where(clause = "venta_o_no = true")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    private boolean ventaONo;

}
