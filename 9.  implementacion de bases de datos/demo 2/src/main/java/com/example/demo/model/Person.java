package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;


import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personas")
//@IdClass(value= PersonKey.class)
@Where(clause = "eliminado = false")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String nombre;
    private boolean eliminado;
    @OneToOne
    private Vehicle vehicle;

}
