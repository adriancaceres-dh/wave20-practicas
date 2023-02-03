package com.example.MapeoDeClavesCompuestas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Persona {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column()
    String nombre;

    @ManyToMany
    @JoinTable(
            name ="compra",
            joinColumns = @JoinColumn( name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Producto> compras;

}
